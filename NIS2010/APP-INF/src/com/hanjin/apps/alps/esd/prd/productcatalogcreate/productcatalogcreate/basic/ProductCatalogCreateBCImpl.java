/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateBCImpl.java
*@FileTitle : ProductCatalogCreate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 정선용
*@LastVersion : 1.0 
* 2009.08.22 정선용
* 1.0 Creation
* history
* 2010.09.27 채창호 [CHM-201006116] : Mixed Term Logic 변경 요청
* 2010.10.04 채창호 [CHM-201006287-01] : [PRD] Session 정보 변경 요청
* 2010.08.31 채창호 [CHM-201005548-01]:[SCEM / PRD] F.H. 기능 연계한 개발요청
* 2011.02.15 채창호 [CHM-201108878] : Group VVD assign시 POD의 location 정보를 PRD로 전달시 yard 제외요청
* 2011.03.07 박만건 [CHM-201108922] : [PRD] MVMT / SO validation 에 대한 오류 팝업 메세지 내용 변경 요청
* 2011.07.25 변종건[CHM-201111865-01] PRD 생성 시 기반 데이터(패러미터 값) 오류 확인 및 수정 요청
* 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
* 2012.07.03 정선용 [CHM-201217726-01] Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청
* 2012.07.18 정선용 [CHM-201217633] 구주 Hinterland, RF 추가
* 2012.08.09 변종건 [CHM-201219565-01] HAMRTM TS 관련 Guide 메세지 제거요청
* 2012.08.17 정선용 [CHM-201219664] [PRD] Canada 향 D7 CNTR BKG block 을 위한 Hard-coding 설정요청	
* 2015.04.10 RAIL CUT OFF TIME 로직 수정
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.common.PrdConstants;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.basic.PrdCreateManageBC;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.basic.PrdCreateManageBCImpl;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.hanjin.apps.alps.esd.prd.common.productcatalogcreateverify.basic.ProductCatalogCreateVerifyBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0081Event;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0083Event;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogCreateDBDAO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogHinterlandDBDAO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogSceDBDAO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogTroDBDAO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCnstRemarkVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdConstraintInfoVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdHinterlandInfoVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdOcnRoutDoubleCallingVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSceGetParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchEurDrRePatternVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdValChkVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SearchCopVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PrdBkgCopMapVO;
import com.hanjin.syscommon.common.table.PrdProdCtlMstVO;


/**
 * ALPS-ProductCatalogCreate Business Logic Command Interface<br>
 * - ALPS-ProductCatalogCreate에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author sun yong Jung
 * @see EventResponse,ProductCatalogCreateDBDAO,ProductCatalogSceDBDAO,ProductCatalogTroDBDAO 각 클래스 참조
 * @since J2EE 1.6
 */
public class ProductCatalogCreateBCImpl extends BasicCommandSupport implements ProductCatalogCreateBC {

	// Database Access Object
	private transient ProductCatalogCreateDBDAO dbDao = null;
	private transient ProductCatalogTroDBDAO dbDaoTro = null;
	private transient ProductCatalogSceDBDAO dbDaoSce = null;
	private transient ProductCatalogHinterlandDBDAO dbDaoHLand = null;

	/**
	 * ProductCatalogCreateBCImpl 객체 생성<br>
	 * ProductCatalogCreateDBDAO를 생성한다.<br>
	 */
	public ProductCatalogCreateBCImpl() {
		dbDao = new ProductCatalogCreateDBDAO();
		dbDaoTro = new ProductCatalogTroDBDAO();
		dbDaoSce = new ProductCatalogSceDBDAO();
		dbDaoHLand = new ProductCatalogHinterlandDBDAO();
	}
	
	/**
	 *** BOOKING MAIN에서 메소드 PC호출시 처리***
	 * Mode B: BKG에서 PC호출시 1개의PC가 생기면 리턴
	 * Mode Y: BKG COPY 
	 * @param prdParameterVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String createPrdCtlgRout(PrdParameterVO prdParameterVO,SignOnUserAccount account ) throws EventException {
		
//		PrdMainInfoVO prdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
		String returnStr ="";
		String rTerm = "";
		String dTerm = "";
		String por = "";
		String del = "";	
		String eurDrChk = "";
		String bkgNo="";
		String returnTerm ="";
		
		String pod = "";
		
		/*
		 * pc를 생성한다.
		 */
  
		// pc no 생성 
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		//bkg에서 받은 parameter를 prd param vo 로 변경.
		EsdPrd0080Event event = (EsdPrd0080Event)prdCreateManageBc.setPrdCreateParam(prdParameterVO);
		rTerm = event.getPrdCreateParamVO().getRcvT();
		dTerm = event.getPrdCreateParamVO().getDelT();
		por = event.getPrdCreateParamVO().getPor();
		del = event.getPrdCreateParamVO().getDel();
		bkgNo = event.getPrdCreateParamVO().getBkgNo();
		
		pod = event.getPrdCreateParamVO().getPod();
		
		//mixed term 을 처리하는 부분
		if (rTerm !=null && (rTerm.equals("M")||rTerm.equals("I"))){
			// term 변경시 원본 데이터 유지를 위해 
			event.getPrdCreateParamVO().setBkgRcvT(rTerm);
			event.getPrdCreateParamVO().setRcvT(prdCreateManageBc.checkMixedRterm(bkgNo,por, rTerm));
			returnTerm = prdCreateManageBc.checkMixedTermYard(event.getPrdCreateParamVO().getRcvT(), event.getPrdCreateParamVO().getPorN());
			if (returnTerm.equals("N")){
				event.getPrdCreateParamVO().setPorN("");
			}
		}
		if (dTerm !=null && (dTerm.equals("M")||dTerm.equals("O"))){
			event.getPrdCreateParamVO().setBkgDelT(dTerm);
			event.getPrdCreateParamVO().setDelT(prdCreateManageBc.checkMixedDterm(bkgNo,del, dTerm));
			returnTerm = prdCreateManageBc.checkMixedTermYard(event.getPrdCreateParamVO().getDelT(), event.getPrdCreateParamVO().getDelN());
			if (returnTerm.equals("N")){
				event.getPrdCreateParamVO().setDelN("");
			}
		}
		
//		/**
//		 * Door / CFS를 제외한 경우 Pod / Del Yard값이 있으면서 POD Yard = Del Yard일 경우 DEL Yard를 지워서 POD를 따라가도록 해야하지 않는가?
//		 */
//		
//		if( null!=event.getPrdCreateParamVO().getPodN() && !"".equals(event.getPrdCreateParamVO().getPodN())
//				&& null!=event.getPrdCreateParamVO().getDelN() && !"".equals(event.getPrdCreateParamVO().getDelN())
//				&& event.getPrdCreateParamVO().getPodN().equals(event.getPrdCreateParamVO().getDelN())) {
//			event.getPrdCreateParamVO().setDelN("");
//		}
		
		/*****************************************************************************
		 * SRM-201113276 Group VVD assign시 POD의 location 정보를 PRD로 전달시 yard 제외요청
		 * BKG Main 에 입력한 POL/POD Node는 Route에 반영하지만
		 * Group VVD Assign, Next VVD Assign 등 VVD assign 시에는 POD Node를 반영하지 않음.
		 * 
		 * (BKG Main에 입력한 POD Node와 Route Detail 마지막 POD Node는 항상 일치)
		 * 20131209 SHIP BACK 일 경우 POD 가 같은게 두번 나올수 있어 보완 필요
		 *****************************************************************************/
		
		if( null!=event.getPrdCreateParamVO().getPod() && !"".equals(event.getPrdCreateParamVO().getPod())
				&& event.getPrdCreateParamVO().getPod().equals(event.getPrdCreateParamVO().getPod1())){
			if( null!=event.getPrdCreateParamVO().getPodN() && !"".equals(event.getPrdCreateParamVO().getPodN())  ){
				if(!event.getPrdCreateParamVO().getPodN().equals(event.getPrdCreateParamVO().getPod1N())){
					event.getPrdCreateParamVO().setPodN("");
				}				
			}
		}
		if(null!=event.getPrdCreateParamVO().getPod() && !"".equals(event.getPrdCreateParamVO().getPod())
				&& event.getPrdCreateParamVO().getPod().equals(event.getPrdCreateParamVO().getPod2())){
			if( null!=event.getPrdCreateParamVO().getPodN() && !"".equals(event.getPrdCreateParamVO().getPodN())  ){
				if(!event.getPrdCreateParamVO().getPodN().equals(event.getPrdCreateParamVO().getPod2N())){
					event.getPrdCreateParamVO().setPodN("");
				}
			}
		}
		if(null!=event.getPrdCreateParamVO().getPod() && !"".equals(event.getPrdCreateParamVO().getPod())
				&& event.getPrdCreateParamVO().getPod().equals(event.getPrdCreateParamVO().getPod3())){
			if( null!=event.getPrdCreateParamVO().getPodN() && !"".equals(event.getPrdCreateParamVO().getPodN())  ){
				if(!event.getPrdCreateParamVO().getPodN().equals(event.getPrdCreateParamVO().getPod3N())){
					event.getPrdCreateParamVO().setPodN("");
				}
			}
		}
		if(null!=event.getPrdCreateParamVO().getPod() && !"".equals(event.getPrdCreateParamVO().getPod())
				&& event.getPrdCreateParamVO().getPod().equals(event.getPrdCreateParamVO().getPod4())){
			if( null!=event.getPrdCreateParamVO().getPodN() && !"".equals(event.getPrdCreateParamVO().getPodN())  ){
				if(!event.getPrdCreateParamVO().getPodN().equals(event.getPrdCreateParamVO().getPod4N())){
					event.getPrdCreateParamVO().setPodN("");
				}
			}
		}
		
		
		
		event.setAttribute("account", account);
		
		try {
			
			PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
			/*
			 * PSEUDO VVD 체크 
			 * BKG-MAIN에서 PSEUDO VVD 를 T-VVD로 사용시 
			 * -.T/S가 있어도 무시하고, LDD로 PC생성.
			 * -.PC는 DIRECT 구간을 리턴하게.
			 * -.PC가 LDD로 생성한 후 VVD 를 PSEUDO VVD로 업데이트 해준다..
			 */
			if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_BASIC) ||
					prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_REPLAN)	) {
				if(prdCreateParamVO.getTVvd()!= null &&  (prdCreateParamVO.getTVvd().contains("HJXX") ||
														  prdCreateParamVO.getTVvd().contains("HJYY") ||
														  prdCreateParamVO.getTVvd().contains("HJZZ"))  ){
					
					prdCreateParamVO.setPseudoVvd(prdCreateParamVO.getTVvd());
					prdCreateParamVO.setTVvd("");
					prdCreateParamVO.setVvd1("");
					prdCreateParamVO.setVvd2("");
					prdCreateParamVO.setVvd3("");
					prdCreateParamVO.setVvd4("");
					prdCreateParamVO.setLane1("");
					prdCreateParamVO.setLane2("");
					prdCreateParamVO.setLane3("");
					prdCreateParamVO.setLane4("");
					
					prdCreateParamVO.setPol1("");
					prdCreateParamVO.setPod1("");
					prdCreateParamVO.setPol2("");
					prdCreateParamVO.setPod2("");
					prdCreateParamVO.setPol3("");
					prdCreateParamVO.setPod3("");
					prdCreateParamVO.setPol4("");
					prdCreateParamVO.setPod4("");
					prdCreateParamVO.setPol1N("");
					prdCreateParamVO.setPod1N("");
					prdCreateParamVO.setPol2N("");
					prdCreateParamVO.setPod2N("");
					prdCreateParamVO.setPol3N("");
					prdCreateParamVO.setPod3N("");
					prdCreateParamVO.setPol4N("");
					prdCreateParamVO.setPod4N("");
					
				}
			}
			
			
			/*
			 * PRD_PC_MOD_BASIC
			 */
			if (prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_BASIC) ) {
				
				/*---------------------------------------------
				 * pc 생성 
				 *---------------------------------------------*/
				this.createPrdCtlgFullRout(event);
				//----------------------------------------------
				
				PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();
				
				// (해당 요건 취소, 아래 요건으로 변경 )pseudo vvd시 direct ocn route를 사용한 pc를 찾아 데이터 정리 후 리턴
				// pc가 생성되면 무조건 하나 리턴으로 변경.
				if( null!=prdCreateParamVO.getPseudoVvd() && !prdCreateParamVO.getPseudoVvd().equals("")){
					// (X)direct ocn route를 사용한 pc를 찾는다.
					// PC가 생성되면 한개를 리터한다.
					returnStr= dbDao.searchDirectOcn(prdPcCreateVO.getHdPctlNo());
					// VVD를 업데이트 한다.
					if(!returnStr.equals("FAIL")){
						// TRUNC VVD를 PSEUDO VVD로 바꾼다. 나머지 VVD는 '' 로 초기화 
						dbDao.updatePrdDtlByPseudoVvd(returnStr,prdCreateParamVO.getPseudoVvd() );
						dbDao.updatePrdMstByPseudoVvd(returnStr,prdCreateParamVO.getPseudoVvd() );
					}
					
				} else {
					// pc가 1개 생성 되면 바로 리턴
					// 1개 이상이면 pc 선택화면 call
		 
					log.debug("\npc min:"+prdPcCreateVO.getMinPctlNo());
					log.debug("\npc max:"+prdPcCreateVO.getMaxPctlNo());
					
					//PC가 한개 일때 -------------------
					if(!prdPcCreateVO.getMinPctlNo().equals("")&& prdPcCreateVO.getMinPctlNo().equals( prdPcCreateVO.getMaxPctlNo() )) {
						//바로 리턴 
//						returnStr = selectReturnStrToBkg(prdPcCreateVO.getMinPctlNo()); // enis 방식 string 리턴 
						returnStr = prdPcCreateVO.getMinPctlNo();
						
						// MT PU DATE 가 입력되었을때 입력값이  SKD보다 뒤이면  EXCEPTION 
						// 입력값이 SKD DATE보다 앞이면 입력값으로 SKD을 변경.
						log.debug("\n getRcvT():["+prdCreateParamVO.getRcvT() +"], getMtPkupDt():["+prdCreateParamVO.getMtPkupDt()+"]");
						if( !prdCreateParamVO.getRcvT().equals("S") && prdCreateParamVO.getMtPkupDt()!= null && !prdCreateParamVO.getMtPkupDt().equals("") ){
							if( checkMtPkupDt(returnStr ,prdCreateParamVO.getMtPkupDt()) ) {
								setMtPkupDt(returnStr, prdCreateParamVO.getMtPkupDt());
							} else {
								//TODO  jsy 메세지.
//								throw new EventException(new ErrorHandler(" Mt PkUp Date invalid!").getMessage());
								throw new EventException(new ErrorHandler("PRD00058").getMessage());
							}
						}
						// constraint 체크 
						List mstList = dbDao.getPrdMst(returnStr);
						log.debug("\n constraint 체크  mstList.size() :"+mstList.size());
						if(mstList.size()>0){
							PrdProdCtlMstVO prdProdCtlMstVO = (PrdProdCtlMstVO)mstList.get(0);
							if(prdProdCtlMstVO.getCnstFlg().equals("X")) {
								log.debug("\n constraint 체크 prdProdCtlMstVO.getCnstFlg() :"+prdProdCtlMstVO.getCnstFlg());
								//service 를 하지않는 곳이 있으므로  메세지 처리 .
//								throw new EventException(new ErrorHandler(" Constraint validation!").getMessage());
								throw new EventException(new ErrorHandler("PRD00059").getMessage());
							}
						}
						/*
						 * bkg main에서 method call 일때 , (basic, replan)
						 * double calling 체크
						 * popup 이 필요없는 화면이 있어서 삭제 .20100226 
						 */
//						if(searchPrdOcnRoutDoubleCalling(prdPcCreateVO).equals("Y")) {
//							returnStr="FAIL";
//						}

						
					} else {
						// PC가 두개 이상 생성됐을때 (PC가 안생겼으면 EXCEPTION으로 보냄)
						returnStr="FAIL";
					}						
				}
				
				
				
			/*
			 * 	PRD_PC_MOD_COPY_VVD_UNCHANGE: Y
			 */
			} else if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_COPY_VVD_UNCHANGE) ){
				//pc_no 는  hd_pctl_no + [1부터 copy_cnt 만큼 증가하면서 ]
				returnStr = createBkgCopyVvdUnchange(event);
				
			/*
			 * 	PRD_PC_MOD_SPLIT_VVD_UNCHANGE: S
			 *  
			 */
			} else if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_SPLIT_VVD_UNCHANGE)) {
				
				this.createBkgSplitVvd(prdParameterVO, account, null, 0 , null);
			/*
			 * 1.bkg replan
			 * 2.group vvd assign 	
			 */				
			} else if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_REPLAN)) {

				
				// cop_map_seq가 붙은 PctlNo
				// 내부에 pseudo vvd를 처리하는 로직 포함됨.
				// PC NO 1개를 리턴해줌.(PC_NO + COP_MAP_SEQ)
				returnStr = createBkgReplane(event);
//				PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO(); // jsy 주패턴의 데이터가 안들어 있게 된다.(마지막 패턴에 대한 정보가 들어있다) 
				
				log.debug("\n pc createBkgReplane return:"+returnStr);
				String mainPatternPcNo = returnStr.substring(0,returnStr.indexOf("|"));
				log.debug("\n pc mainPatternPcNo :"+mainPatternPcNo);
				// MT PU DATE 가 입력되었을때 입력값이  SKD보다 뒤이면  EXCEPTION 
				// 입력값이 SKD DATE보다 앞이면 입력값으로 SKD을 변경.
				log.debug("\n getRcvT():["+prdCreateParamVO.getRcvT() +"], getMtPkupDt():["+prdCreateParamVO.getMtPkupDt()+"]");
				if( !prdCreateParamVO.getRcvT().equals("S") && prdCreateParamVO.getMtPkupDt()!= null && !prdCreateParamVO.getMtPkupDt().equals("") ){
//					if( checkMtPkupDt(prdPcCreateVO.getMinPctlNo() ,prdCreateParamVO.getMtPkupDt()) ) {
					if( checkMtPkupDt(mainPatternPcNo ,prdCreateParamVO.getMtPkupDt()) ) {
						// mt dt 를 변경해준다. 
//						setMtPkupDt(prdPcCreateVO.getMinPctlNo(), prdCreateParamVO.getMtPkupDt());
						setMtPkupDt(mainPatternPcNo, prdCreateParamVO.getMtPkupDt());
					} else {
//						throw new EventException(new ErrorHandler(" Mt PkUp Date invalid!").getMessage());
						throw new EventException(new ErrorHandler("PRD00058").getMessage());
						
					}
				}
				

				// constraint 체크 
//				List mstList = dbDao.getPrdMst(prdPcCreateVO.getMinPctlNo());
				List mstList = dbDao.getPrdMst(mainPatternPcNo);
				log.debug("\n constraint 체크  mstList.size() :"+mstList.size());
				if(mstList.size()>0){
					PrdProdCtlMstVO prdProdCtlMstVO = (PrdProdCtlMstVO)mstList.get(0);
					log.debug("\n constraint 체크 prdProdCtlMstVO.getCnstFlg() :"+prdProdCtlMstVO.getCnstFlg());
					if(prdProdCtlMstVO.getCnstFlg().equals("X")) {
						//service 를 하지않는 곳이 있으므로  메세지 처리 .
//						throw new EventException(" Constraint validation!");
						throw new EventException(new ErrorHandler("PRD00059").getMessage());
					}
				}	
				
				// EUR TRO 처리 시작
				// 1. EUR TRO 처리가 있는 지 확인한다.
				// 2. ERU TRO 처리가 필요한 PATTERN으로 다시 조사한다.-- 기존 PATTERN 무시
				//    --> 1) POR/DEL NODE와 다른 구주 지역의 S/O나 TRO가 있으면 
				//        2) S/O있으면 S/O 우선 없으면 TRO DATA SEARCH
				// 3. 새로운 형태로 TRO PC를 생성하고 PC NO를 UPDATE 한다.
				
					
//				try {
					eurDrChk = dbDao.chkEurDr(prdCreateParamVO.getBkgNo()) ;
					
					if(eurDrChk.equals("Y")) {
	                    // 새로 변경할 것만 pattern ord 신규로 setting
						dbDao.updatePrdMapReInit(prdCreateParamVO.getBkgNo(),event.getAttribute("eur_dr_seq")+"") ;
						
						// 작업 대상 select
						List<PrdSearchEurDrRePatternVO> eurDrList = dbDao.getEurDr(prdCreateParamVO.getBkgNo(),event.getAttribute("eur_dr_seq")+"") ;	
						
						// pc 생성
						PrdSearchEurDrRePatternVO prdSearchEurDrRePatternVO = null;
						for(int i=0; i<eurDrList.size(); i++){
							
							prdSearchEurDrRePatternVO = (PrdSearchEurDrRePatternVO)eurDrList.get(i);
							
//							log.debug("New POR :" + prdSearchEurDrRePatternVO.getNewPor());
//							log.debug("New POL :" + prdSearchEurDrRePatternVO.getNewPol());
//							log.debug("New POD :" + prdSearchEurDrRePatternVO.getNewPod());
//							log.debug("New DEL :" + prdSearchEurDrRePatternVO.getNewDel());
							
							PrdPatternVO prdPatternVO = new PrdPatternVO();
							prdPatternVO.setObItchgCtnt(prdSearchEurDrRePatternVO.getObContent());
							prdPatternVO.setIbItchgCtnt(prdSearchEurDrRePatternVO.getIbContent());
							prdPatternVO.setOcnItchgCtnt(prdSearchEurDrRePatternVO.getOcnContent());						
							
							createPrdCtlgEurDoor(event,prdSearchEurDrRePatternVO,prdPatternVO ); //패턴 타임아웃
	
						}
						
					}
//				} catch (Exception ex) {
//					log.error("err " + ex.toString(), ex);
//					throw new EventException(new ErrorHandler(ex).getMessage());
//				}
				
				/*
				 * bkg main에서 method call 일때 , (basic, replan)
				 * double calling 체크 
				 * popup 이 필요없는 화면이 있어서 삭제 .20100226
				 */
//				if(searchPrdOcnRoutDoubleCalling(prdPcCreateVO).equals("Y")) {
//					returnStr="FAIL";
//				}
				
			//kim kwijin추가
			//TRO
			} else if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_I) || prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_O ) ){
				returnStr =createIrgSoReplane(event,account.getUsr_id());
//				returnStr = event.getPrdPcCreateVO().getMinPctlNo(); 
				
			}
			//kim kwijin추가
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		 
		log.debug("\n\n -------------------------------------------------------------" +
				"\n ♡ ♡♡♡♡♡♡                      PC 는 끝.     ♡♡♡♡♡♡♡♡♡♡♡♡♡♡" +
				"\n ★★★★★             createPrdCtlgRout end return :"+returnStr+
				"\n----------------------------------------------------------------\n\n");
		return returnStr;
		
	}

	/**
	 *  split bkg 별로 bkg에서 call
	 * @param PrdParameterVO prdParameterVO
	 * @param SignOnUserAccount account
	 * @param List<String> cntrList
	 * @param int splitSeq
	 * @param List<String> bkgNoList
	 * @return String
	 * @throws EventException
	 */
	public String createPrdCtlgRoutSplit(PrdParameterVO prdParameterVO, SignOnUserAccount account, List<String> cntrList, int splitSeq , List<String> bkgNoList) throws EventException {
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		EsdPrd0080Event event = (EsdPrd0080Event)prdCreateManageBc.setPrdCreateParam(prdParameterVO);
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
			/*
			 * 	PRD_PC_MOD_COPY_VVD_UNCHANGE: Y
			 */
		String copMapSeq = null;  // ""
		if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_COPY_VVD_UNCHANGE) ){
			//pc_no 는  hd_pctl_no + [1부터 copy_cnt 만큼 증가하면서 ]
			this.createBkgCopyVvdUnchange(event);

			/*
			 * 	PRD_PC_MOD_SPLIT_VVD_UNCHANGE: S
			 *
			 */
		} else if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_SPLIT_VVD_UNCHANGE)) {
			copMapSeq = this.createBkgSplitVvd(prdParameterVO, account, cntrList, splitSeq, bkgNoList );
		}
		log.debug("\n\n createPrdCtlgRoutSplit return: "+copMapSeq);
		return copMapSeq;
	}
	
	/**
	 * @param e
	 * @return 1개의 pc no 만 리턴
	 * @throws EventException
	 */
	private String createBkgReplane(Event e) throws EventException {

		EsdPrd0080Event event = (EsdPrd0080Event)e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		SignOnUserAccount account = (SignOnUserAccount)e.getAttribute("account");
		String cntrTpszQtyStr = "";
		// CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청
		//D4@4@BKG,D5@6@SO 형식을 타입 만들기 
		cntrTpszQtyStr = this.getReplanCntrTpszQty(prdCreateParamVO.getBkgNo() , event.getPrdQuantityVOs());
		prdCreateParamVO.setCntrTpszQtyStr(cntrTpszQtyStr);
		/**
		 * replane check
		 */
		//// CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청 추가  메소드 파라메터 변경
		//COP개발후 주석 풀어줌.
		//checkReplan(e);ㅏ
		checkReplan(prdCreateParamVO);

		List<PrdPatternVO> list = null;
		
		//pattern 시 term 정보는 prd에서 변경한 정보가 아닌 원본 term 데이터를 사용(mixed)----------
		String orgRterm ="";
		String orgDterm ="";
		String chgRterm ="";
		String chgDterm ="";
		
		if( null!=prdCreateParamVO.getBkgRcvT() && prdCreateParamVO.getBkgRcvT().equals("M")) {
			orgRterm = prdCreateParamVO.getBkgRcvT();
		} 
		chgRterm = prdCreateParamVO.getRcvT();
		
		if( null!=prdCreateParamVO.getBkgDelT() &&  prdCreateParamVO.getBkgDelT().equals("M")) {
			orgDterm = prdCreateParamVO.getBkgDelT();
		} 
		chgDterm = prdCreateParamVO.getDelT();
					
		//------------------------------------------------------------------------------------
		
		/*
		 * pseudo vvd 를 위한 로직 jsy 
		 */
		if( null!=prdCreateParamVO.getPseudoVvd() && !prdCreateParamVO.getPseudoVvd().equals("")){
            //CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청 
			//list = this.getReplanePattern(event.getPrdQuantityVOs(), prdCreateParamVO.getBkgNo(), prdCreateParamVO.getBkgOfc()
			//		, orgRterm, orgDterm, chgRterm, chgDterm, "V" ;
			list = this.getReplanePattern(event.getPrdQuantityVOs(), prdCreateParamVO.getBkgNo(), prdCreateParamVO.getBkgOfc()
					, orgRterm, orgDterm, chgRterm, chgDterm, "V" ,prdCreateParamVO.getFlexHgtFlg() ,prdCreateParamVO.getCntrTpszQtyStr());
		} else {
		
		
			/**
			 * 패턴 검사 
			 * 1.map table의 CRNT_FLGfmf 'N'으로 update한다.
			 * 2.PRD_BKG_COP_MAP_SEQ sequence를 얻는다.
			 * 3.prd map 생성 
			 * 4.prd map qty 보정
			 * 5.COP_PATT_ORD_NO 의 데이터만큼 PC를 생성하기 위해 COP_PATT_ORD_NO 의 데이터를 GROUP BY 로 가져온다.
			 */
			//CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청 
//			list = this.getReplanePattern(event.getPrdQuantityVOs(), prdCreateParamVO.getBkgNo(),
//					prdCreateParamVO.getBkgOfc(), orgRterm, orgDterm, chgRterm, chgDterm, "P" );
			list = this.getReplanePattern(event.getPrdQuantityVOs(), prdCreateParamVO.getBkgNo(),
					prdCreateParamVO.getBkgOfc(), orgRterm, orgDterm, chgRterm, chgDterm, "P" ,prdCreateParamVO.getFlexHgtFlg() ,prdCreateParamVO.getCntrTpszQtyStr());
		}
		/**
		 * 패턴 수만큼 replane pc생성
		 */
		//패턴이 없으면 pc생성 
		PrdPatternVO prdPatternVO = null;
		
		//cho
		log.debug("\n\n TESTEST-----------");
		EsdPrd0080Event eventcho = (EsdPrd0080Event)e;
		log.debug("\n\n -------------------------------" +
				"\n createBkgReplane getTVvd:"+eventcho.getPrdCreateParamVO().getTVvd()+
				"\n createBkgReplane getVvd1:"+eventcho.getPrdCreateParamVO().getVvd1()+
				"\n createBkgReplane getVvd2:"+eventcho.getPrdCreateParamVO().getVvd2());
		
		// TODO delete noh
		//PrdCreateParamVO prdCreateParamVO = eventcho.getPrdCreateParamVO();

		//CHO END
		String returnPctlNo ="";
		String subPatternPctlNo ="";
		
		if(list ==null || list.size() <1 ){
			log.debug("\n\n list ==null-----------");
//			throw new EventException("pattern not found!");
			// replan 대상이 없음. Could not find route pattern for replan. Please check COP status.
			throw new EventException(new ErrorHandler("PRD00062").getMessage());
/*			
			//replane pc생성
			createPrdCtlgIncludeReplane(e,prdPatternVO );
			log.debug("\n\n replane pc생성  createPrdCtlgIncludeReplane end-----------");
			// TODO delete noh //EsdPrd0080Event event = (EsdPrd0080Event)e;
			PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();
			
			log.debug("\n\n prdPcCreateVO.getMinPctlNo()-----------"+prdPcCreateVO.getMinPctlNo());
			log.debug("\n\n prdPcCreateVO.getMaxPctlNo()-----------"+prdPcCreateVO.getMaxPctlNo());
			if(prdPcCreateVO.getMaxPctlNo().equals("")){
				if(prdCreateParamVO == null || prdPcCreateVO == null || "".equals(prdCreateParamVO.getPol()) ){
					log.debug("\n noh prdCreateParamVO is :"+(prdCreateParamVO == null));
					log.debug("\n noh prdPcCreateVO is :"+(prdPcCreateVO == null));
					log.debug("\n noh pol is white space :"+prdCreateParamVO.getPol());
					throw new EventException("verify 실행하기 위한 값이 없습니다.");
				}

				String verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(prdCreateParamVO, prdPcCreateVO, null);
				log.debug("\n noh verifyMessage \n"+verifyMessage);
				throw new EventException(verifyMessage);

				//throw new EventException("Replane PC 생성 실패" );
			}else if(!prdPcCreateVO.getMinPctlNo().equals("")&& !(prdPcCreateVO.getMinPctlNo().equals( prdPcCreateVO.getMaxPctlNo()) )){
				throw new EventException("Replane PC 2개 이상 생성" );
			}else {
				//1개만 생성시 통과.
				// map 테이블 update (cop_patt_ord_no=1 , COP_MAPG_SEQ 로 찾아 pc no update) 
				//updatePrdMapByPcCreate(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq(),prdPcCreateVO.getMinPctlNo(),prdCreateParamVO.getBkgNo() );
				this.updatePrdMapByPcCreate(prdPatternVO ,prdPcCreateVO.getMinPctlNo(),prdCreateParamVO.getBkgNo() );
				returnPctlNo = prdPcCreateVO.getMinPctlNo();
			}	
*/			
		}else {
			
			log.error("\n list.size():"+ list.size());
			for(int i=0; i<list.size(); i++){
				log.debug("\n 패턴으로 pc를 생성한다.pattern count:"+ list.size());
				
				
				//ord= 1인 주패턴으로 pc를 생성한다.
				prdPatternVO = (PrdPatternVO)list.get(i);
				if(prdPatternVO.getCopPattOrdNo().equals("1")){
				    log.debug("\n ord= 1 main pattern pc create------------------");
					
				    // pc생성 -----------------------------------
					createPrdCtlgIncludeReplane(e,prdPatternVO );
					// pc생성 -----------------------------------
					
					// psedo vvd 일 경우 pc가 몇개 만들어지더라도 1개만 선택해서 리턴해준다.-------------------
					PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();
					
					if( null!=prdCreateParamVO.getPseudoVvd() && !prdCreateParamVO.getPseudoVvd().equals("")){
						// PSEUDO REPLAN처리 
						try {

					    // psedo vvd 일 경우 pc가 몇개 만들어지더라도 1개만 선택해서 리턴해준다.
							event.setAttribute("eur_dr_seq", prdPatternVO.getCopMapgSeq());
							returnPctlNo= dbDao.searchDirectOcn(prdPcCreateVO.getHdPctlNo());
						// VVD를 업데이트 한다.
							if(!returnPctlNo.equals("FAIL")){
								dbDao.updatePrdDtlByPseudoVvd(returnPctlNo,prdCreateParamVO.getPseudoVvd() );
								dbDao.updatePrdMstByPseudoVvd(returnPctlNo,prdCreateParamVO.getPseudoVvd() );
								
								// map 테이블 update (cop_patt_ord_no=1 , COP_MAPG_SEQ 로 찾아 pc no update) 
								updatePrdMapByPcCreate(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq(),returnPctlNo, prdCreateParamVO.getBkgNo() );
	                            event.setAttribute("eur_dr_seq", prdPatternVO.getCopMapgSeq());
								returnPctlNo = returnPctlNo+"|"+prdPatternVO.getCopMapgSeq();	
								log.debug("\n\n----------------------------------------------------" +
										"\n pseudo vvd시 replan pc 생성 성공 PCTL no + map seq =["+returnPctlNo +"]" +
									    "\n--------------------------------------------------------");
															
							}
						}catch(DAOException ex){
							throw new EventException(ex.getMessage(), ex);
						}catch(Exception ex){
							throw new EventException(ex.getMessage(), ex);
						}	
						
					} else {
						// 일반 리플랜 처리 
						// TODO delete noh //EsdPrd0080Event event = (EsdPrd0080Event)e;
//						PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();
						

						log.debug("\n\n MIN -----------"+prdPcCreateVO.getMinPctlNo());
						log.debug("\n\n MAX -----------"+prdPcCreateVO.getMaxPctlNo());
						
						if(prdPcCreateVO.getMaxPctlNo().equals("")){
							if(prdCreateParamVO == null || prdPcCreateVO == null || "".equals(prdCreateParamVO.getPol()) ){
								log.debug("\n noh prdCreateParamVO is :"+(prdCreateParamVO == null));
								log.debug("\n noh prdPcCreateVO is :"+(prdPcCreateVO == null));
								if(prdCreateParamVO!=null){
									log.debug("\n noh pol is white space :"+prdCreateParamVO.getPol());
								}
								throw new EventException(new ErrorHandler("PRD00075").getMessage());
							}else{
								

							String verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(prdCreateParamVO, prdPcCreateVO, prdPatternVO);
							log.debug("\n noh verifyMessage \n"+verifyMessage);
//							throw new EventException(verifyMessage);
							throw new EventException(new ErrorHandler("PRD99998",new String[]{verifyMessage }).getMessage());
							//pc생성 실패 (주패턴)
							//throw new EventException("Replane PC 생성 실패" );
							}

						}else if(!prdPcCreateVO.getMinPctlNo().equals("")&& !(prdPcCreateVO.getMinPctlNo().equals( prdPcCreateVO.getMaxPctlNo()) )){
							throw new EventException(new ErrorHandler("PRD00077").getMessage());
						}else {
							//1개만 생성시 통과.
							// map 테이블 update (cop_patt_ord_no=1 , COP_MAPG_SEQ 로 찾아 pc no update) 
							updatePrdMapByPcCreate(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq(),prdPcCreateVO.getMinPctlNo(),prdCreateParamVO.getBkgNo() );
							event.setAttribute("eur_dr_seq", prdPatternVO.getCopMapgSeq());
							returnPctlNo = prdPcCreateVO.getMinPctlNo() +"|"+prdPatternVO.getCopMapgSeq();
							// eur tro 처리함. --주 패턴 하나의 pc만으로 끝난 경우
							log.debug("\n\n----------------------------------------------------" +
									"\n replan pc 생성 성공 PCTL no + map seq =["+returnPctlNo +"]" +
								    "\n--------------------------------------------------------");
						}
					}

					
					
					
				} else{
					//부패턴 PC생성(실패해도 무시)
					log.debug("\n ord> 1 , sub pattern pc create.------------------");
					
					//----------------------------------------- 
					createPrdCtlgIncludeReplane(e,prdPatternVO );
					//pc 생성----------------------------------------- 
					
					
					// pseudo vvd시 direct ocn route를 사용한 pc를 찾아 데이터 정리 후 리턴
					PrdPcCreateVO prdPcCreateVO = event.getPrdPcCreateVO();
					
					if( null!= prdCreateParamVO.getPseudoVvd() && !prdCreateParamVO.getPseudoVvd().equals("")){
						// pseudo vvd 처리 (부패턴)
						try {
							// direct ocn route를 사용한 pc를 찾는다.
							subPatternPctlNo= dbDao.searchDirectOcn(prdPcCreateVO.getHdPctlNo());
							// VVD를 업데이트 한다.
							if( subPatternPctlNo.equals("FAIL")){
								int updateCnt  = dbDao.updatePrdMapByPcCreateFail(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq() );
								if((updateCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
									log.debug("\n\n PRD log On:");
									Map map = new HashMap();
									
									map.put("PrdPatternVO", prdPatternVO);
									map.put("usrId", account.getUsr_id());
									
									String logDesc =  this.getParamString(map);
									log.debug("\n\n log::::"+logDesc );
									dbDao.createPrdExecEnisLog(logDesc ,"createBkgReplane F_1", account.getUsr_id());
								}
							} else {
								dbDao.updatePrdDtlByPseudoVvd(subPatternPctlNo,prdCreateParamVO.getPseudoVvd() );
								dbDao.updatePrdMstByPseudoVvd(subPatternPctlNo,prdCreateParamVO.getPseudoVvd() );
	
								// map 테이블 update (cop_patt_ord_no=1 , COP_MAPG_SEQ 로 찾아 pc no update) 
								int successCnt = updatePrdMapByPcCreate(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq(),subPatternPctlNo, prdCreateParamVO.getBkgNo() );
								if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
									log.debug("\n\n PRD log On:");
									Map map = new HashMap();
									
									map.put("PrdCreateParamVO", prdCreateParamVO);
									map.put("PrdPatternVO", prdPatternVO);
									map.put("subPatternPctlNo", subPatternPctlNo);
									map.put("BkgNo", prdCreateParamVO.getBkgNo());
									map.put("usrId", account.getUsr_id());
									
									String logDesc =  this.getParamString(map);
									log.debug("\n\n log::::"+logDesc );
									dbDao.createPrdExecEnisLog(logDesc ,"createBkgReplane S_1", account.getUsr_id());
								}
							}
						}catch(DAOException ex){
							throw new EventException(ex.getMessage(), ex);
						}catch(Exception ex){
							throw new EventException(ex.getMessage(), ex);
						}	
						
					} else {
						// 일반 리플랜 처리  (부패턴)
						// TODO delete noh // EsdPrd0080Event event = (EsdPrd0080Event)e;
						if(prdPcCreateVO.getMaxPctlNo().equals("")){
							//pc생성 실패 (부패턴)시 COP_OP_TP_CD fail 로 업데이트.
							log.debug("\n ord> 1 , sub pattern pc create fail.------------------");
							try{
								int updateCnt = dbDao.updatePrdMapByPcCreateFail(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq() );
								if(( dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
									log.debug("\n\n PRD log On:");
									Map map = new HashMap();
									
									map.put("PrdPatternVO", prdPatternVO);
									map.put("usrId", account.getUsr_id());
									
									String logDesc = "successFlag " + Integer.toString(updateCnt) + " " + this.getParamString(map);
									log.debug("\n\n log::::"+logDesc );
								
									
//									dbDao.createPrdExecEnisLog(log_desc,app_info);
									dbDao.createPrdExecEnisLog(logDesc ,"createBkgReplane SM_F", account.getUsr_id());
								}
							} catch(DAOException ex){
								throw new EventException(ex.getMessage(), ex);
							}catch(Exception ex){
								throw new EventException(ex.getMessage(), ex);
							}
						}else {
							//1개만 생성시 통과.
							// map 테이블 update (cop_patt_ord_no>1 , COP_MAPG_SEQ 로 찾아 pc no update) 
							log.debug("\n ord> 1 , sub pattern pc create success.------------------");
							int updateCnt = updatePrdMapByPcCreate(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq(),prdPcCreateVO.getMinPctlNo(),prdCreateParamVO.getBkgNo() );
							try {
								if(( dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
									log.debug("\n\n PRD log On:");
									Map map = new HashMap();
									
									map.put("PrdPatternVO", prdPatternVO);
									map.put("MinPctlNo", prdPcCreateVO.getMinPctlNo());
									map.put("BkgNo", prdCreateParamVO.getBkgNo());
									map.put("usrId", account.getUsr_id());
									
									String logDesc = "successFlag " + Integer.toString(updateCnt) + " " + this.getParamString(map);
									log.debug("\n\n log::::"+logDesc );
 
									dbDao.createPrdExecEnisLog(logDesc ,"createBkgReplane SM_F", account.getUsr_id());
								}
							} catch (DAOException e1) {
								log.error("err " + e1.toString(), e1);
								throw new EventException(new ErrorHandler(e1).getMessage());
							}
						}						
					}
					

				} //부패턴 전체 ----------------------------------
			} //---pattern list for loop end
		}
		return returnPctlNo;
		
	}


	/**
	 * BKG 에서 "HJXX HJZZ HJYY" 인 vvd를 포함하는 vvd assign 시  바로 호출하는 메소드
	 * @param PrdParameterVO prdParameterVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String updateBkgAssignVvd(PrdParameterVO prdParameterVO, SignOnUserAccount account) throws EventException{
		EsdPrd0080Event event = (EsdPrd0080Event)new PrdCreateManageBCImpl().setPrdCreateParam(prdParameterVO);
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		//CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청 추가 
        String cntrTpszQtyStr = "";
		
		//D4@4@BKG,D5@6@SO 형식을 타입 만들기 
        cntrTpszQtyStr = this.getReplanCntrTpszQty(prdCreateParamVO.getBkgNo() , event.getPrdQuantityVOs());
		prdCreateParamVO.setCntrTpszQtyStr(cntrTpszQtyStr);

		String pod = null;
		String vvd = null;
//		String hj = "HJXX HJZZ HJYY";
		String hj = "SMXX SMZZ SMYY";
		
		String pol = null;

//		if(hj.contains((prdCreateParamVO.getTVvd()+"    ").substring(0, 4)) ){
////			vvd =  prdCreateParamVO.getTVvd();
//			vvd =  "";
//			pod = prdCreateParamVO.getPod();
//		}else 
		if(hj.contains((prdCreateParamVO.getVvd1()+"    ").substring(0, 4)) ){
//			vvd =  prdCreateParamVO.getVvd1();
			vvd =  "";
			pod = prdCreateParamVO.getPod1();
			pol = prdCreateParamVO.getPol1();
		}else if(hj.contains((prdCreateParamVO.getVvd2()+"    ").substring(0, 4)) ){
//			vvd =  prdCreateParamVO.getVvd2();
			vvd =  "";
			pod = prdCreateParamVO.getPod2();
			pol = prdCreateParamVO.getPol2();
		}else if(hj.contains((prdCreateParamVO.getVvd3()+"    ").substring(0, 4)) ){
//			vvd =  prdCreateParamVO.getVvd3();
			vvd =  "";
			pod = prdCreateParamVO.getPod3();
			pol = prdCreateParamVO.getPol3();
		}else if(hj.contains((prdCreateParamVO.getVvd4()+"    ").substring(0, 4)) ){
//			vvd =  prdCreateParamVO.getVvd4();
			vvd =  "";
			pod = prdCreateParamVO.getPod4();
			pol = prdCreateParamVO.getPol4();
		}
		String pctlNo = null;
		if(vvd != null ){
            //CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청 으로 파라메터 변경 
			//this.checkReplan(event);
			this.checkReplan(prdCreateParamVO);

			String bkgNo = prdCreateParamVO.getBkgNo();

			try {
				// TODO delete noh
				//dbDao.updateAssignVvdMaster(bkgNo, vvd);
				int successFlag = dbDao.updateAssignVvdDetail(bkgNo, vvd, pol, pod, account.getUsr_id());
				if((successFlag == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					
					map.put("PrdCreateParamVO", prdCreateParamVO);
					map.put("vvd", vvd);
					map.put("pod", pod);
					map.put("pol", pol);
					map.put("usrId", account.getUsr_id());
					
					String logDesc =  this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					dbDao.createPrdExecEnisLog(logDesc ,"updateBkgAssignVvd", account.getUsr_id());
				}
				
			} catch(DAOException ex){
				throw new EventException(ex.getMessage(), ex);
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}

			//List list = this.getReplanePattern(e, "V");
			// 여기서는 term 변경이 없었으므로 그대로 term 사용
			//CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청
//			List list = this.getReplanePattern(event.getPrdQuantityVOs(), bkgNo, prdCreateParamVO.getBkgOfc()
//					, prdCreateParamVO.getRcvT(), prdCreateParamVO.getDelT(), prdCreateParamVO.getRcvT(), prdCreateParamVO.getDelT(), "V");
			List<PrdPatternVO> list = this.getReplanePattern(event.getPrdQuantityVOs(), bkgNo, prdCreateParamVO.getBkgOfc()
					, prdCreateParamVO.getRcvT(), prdCreateParamVO.getDelT(), prdCreateParamVO.getRcvT(), prdCreateParamVO.getDelT(), "V" ,prdCreateParamVO.getFlexHgtFlg() ,prdCreateParamVO.getCntrTpszQtyStr());
			if(list != null && list.size() > 0){
				pctlNo = ((PrdPatternVO)list.get(0)).getPctlNo() +"|"+((PrdPatternVO)list.get(0)).getCopMapgSeq();;
			}
		}
		return pctlNo;
	}
	
//	private void updatePrdMapByPcCreate(PrdPatternVO prdPatternVO,
//			String minPctlNo, String bkgNo) throws EventException {
//		try {
//			dbDao.updatePrdMapByPcCreate(prdPatternVO, minPctlNo,bkgNo );
//		} catch(DAOException ex){
//			throw new EventException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			throw new EventException(ex.getMessage(), ex);
//		}
//		
//	}

	/**
	 * @param copPattOrdNo
	 * @param copMapgSeq
	 * @param minPctlNo
	 * @param bkgNo
	 * @throws EventException
	 */
	private int updatePrdMapByPcCreate(String copPattOrdNo, String copMapgSeq,
			String minPctlNo, String bkgNo) throws EventException {
		int successCnt = 0;
		try {
			successCnt = dbDao.updatePrdMapByPcCreate(copPattOrdNo, copMapgSeq, minPctlNo,bkgNo );
		} catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return successCnt;
	}

	/**
	 * @param PrdQuantityVO[] prdQuantityVOs
	 * @param String bkgNo
	 * @param String bkgOfc
	 * @param String bkgRcvT
	 * @param String bkgDelT
	 * @param String chgRterm
	 * @param String chgDterm
	 * @param String currentFlag
	 * @param String flxHgtFlg
	 * @param String cntrTpszQty
	 * @return List<PrdPatternVO>
	 * @throws EventException
     * CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청 으로 파라메터 변경 
	 */
	private List<PrdPatternVO> getReplanePattern(PrdQuantityVO[] prdQuantityVOs, String bkgNo, String bkgOfc, String bkgRcvT, String bkgDelT, String chgRterm, String chgDterm, String currentFlag
			                       ,String flxHgtFlg , String cntrTpszQty) throws EventException {

 		List<PrdPatternVO> prdPatternVOs = null;
 		List<PrdBkgCopMapVO> prdBkgCopMapVOs = new ArrayList<PrdBkgCopMapVO>();
 		try{
			// map table의 CRNT_FLG를 'N'으로 update한다. 
			dbDao.updatePrdMapInit(bkgNo, "");

			// PRD_BKG_COP_MAP_SEQ sequence를 얻는다.
			String mapSeq = dbDao.getPrdBkgCopMapSeq();
			
			//prd map 생성 
			prdBkgCopMapVOs = dbDao.getReplanePattern(bkgRcvT, bkgDelT, chgRterm, chgDterm, bkgNo, mapSeq, currentFlag ,flxHgtFlg , cntrTpszQty , bkgOfc);
            dbDao.addReplanPatterns(prdBkgCopMapVOs);
            
			// COP_PATT_ORD_NO 의  데이터를 GROUP BY 로 가져온다.
			// COP_PATT_ORD_NO 의 데이터만큼 PC를 생성
            prdPatternVOs  = dbDao.searchCurrentPatternOrd(mapSeq);
			log.debug("\n\n getReplanePattern end-----------------------");
			//mapSeq 로 map 데이터를 읽는다.( 패턴을 포함한 pc를 생성하기 위해 pattern 을 읽는것)
		}catch(DAOException ex){
			//이전 소스수정본으로 다시 돌려본다.(위 로직 안정화되면 삭제)---------------------------
			try {
				dbDao.updatePrdMapInit(bkgNo, "");
				String mapSeq = dbDao.getPrdBkgCopMapSeq();
				prdBkgCopMapVOs = dbDao.getReplanePatternOld(bkgRcvT, bkgDelT, chgRterm, chgDterm, bkgNo, mapSeq, currentFlag ,flxHgtFlg ,cntrTpszQty, bkgOfc );
	            dbDao.addReplanPatterns(prdBkgCopMapVOs);
	            prdPatternVOs  = dbDao.searchCurrentPatternOrd(mapSeq);
	            
	            if((dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					map.put("mapSeq", mapSeq);
					map.put("bkgRcvT", bkgRcvT);
					map.put("bkgDelT", bkgDelT);
					map.put("chgRterm", chgRterm);
					map.put("chgDterm", chgDterm);
					map.put("bkgNo", bkgNo);
					map.put("currentFlag", currentFlag);
					map.put("flxHgtFlg", flxHgtFlg);
					map.put("cntrTpszQty", cntrTpszQty);
					map.put("bkgOfc", bkgOfc);
					
					String logDesc = "prd_map " + this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					
					dbDao.createPrdExecEnisLog(logDesc ,"getReplanePattern", "system");
				}
	            
	            return prdPatternVOs;
			} catch (Exception e2) {
				throw new EventException(e2.getMessage(), e2);
			}
			//--------------------------------------------------------------------------			
//			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return prdPatternVOs;
	}
	
	
	/**
	 * @param PrdCreateParamVO prdCreateParamVO
	 * @throws EventException
	 * CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청 메소드 추가
	 */
	public void checkReplan(PrdCreateParamVO prdCreateParamVO) throws EventException {
		DBRowSet dbR = null; 
		try {
			/*
			 *미주 발 BKG 경우, 미주 Outboudn S/O 발행 후 POL BKG Update 시, 
			 *S/O 를 연결 하는 Route 가 존재 하지 않을 경우 Validation 하여 BKG 변경 불가 (2009-08-26)
			 *2010==> replane시 패턴별로  so를 포함한 pc를 만들므로 이 validation은 어느정도 반영되어 있다고 할수 있다.
			 *나중 유저 가 요구시 개발  
			 */
			
//			String isUSA = prdCreateParamVO.getPor().substring(0, 2);
//			log.debug("\nisUsa:"+isUSA);
//			if (isUSA.equals("US") ){
//				soConnectRouteCheck(e);
//			}
			//------------------------------------------------------------
			
			  
			dbR =dbDao.checkReplane(prdCreateParamVO.getPor(), prdCreateParamVO.getPol(), prdCreateParamVO.getPod(), 
					prdCreateParamVO.getDel(), prdCreateParamVO.getTVvd(), prdCreateParamVO.getRcvT(), 
					prdCreateParamVO.getDelT(), prdCreateParamVO.getBkgNo());
			
			if(dbR.next()){
				String errCd = dbR.getString("e_cd");
				String orgPctlNo = dbR.getString("pctl_no");
				String orgPctlSeq = dbR.getString("pctl_seq");
				// CHM-201108922 - [PRD] MVMT / SO validation 에 대한 오류 팝업 메세지 내용 변경 요청
				String errTp = dbR.getString("e_tp");
				String errSoBnd = dbR.getString("so_bnd");
				String errMvmtBnd = dbR.getString("mvmt_bnd");
				
				log.debug("\n ------------------------------------------------------------------" +
						  "\n   replan check code :" +errCd+
						  "\n-------------------------------------------------------------------");
				
				if(!errCd.equals(PrdConstants.PRD_REPLAN_CHK_CD_E0000)) {
					//error - need to mapping the error message
					/*
					E0001 : Could not change the POR
					E0002 : Could not change the POL
					E0003 : Could not change the VVD
					E0004 : Could not change the POD
					E0005 : Could not change the DEL
					E0006 : Could not change the Receive Term
					E0007 : Could not change the Delivery Term
					E0009 : This status could not be replanned when the actual movement in COP status is IC, TN which is "I/B Truck terminal arrival or departure". 
							Please, change the status to "YES"
					*/
					String errMSg = "";
					if(errCd.equals("E0001")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0002")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0003")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0004")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0005")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0006")) {
						errMSg = "PRD00014";
					} else if (errCd.equals("E0007")) {
						errMSg = "PRD00014";
					}  else if (errCd.equals("E0009")) {
						errMSg = "PRD00055";
					}
					else {
						errMSg = "PRD00013";
					}
					
					// CHM-201108922 - [PRD] MVMT / SO validation 에 대한 오류 팝업 메세지 내용 변경 요청
					if (!errMSg.equals("")) {
						if(errTp.equals("MVMT")) {
							// The BKG can’t be updated with current CNTR MVMT status. Pls change “Status Change” of COP from “NO” to “YES” to update the BKG.
							errMSg = "PRD00078";
						} else if (errTp.equals("SOWO")) {
							// S/O of containers have been created already. Pls check the S/O of this booking in advance.
							errMSg = "PRD00014";
						} else if (errTp.equals("ALL")) {
							// Pls check both below to update the BKG
							// The BKG can’t be updated with current CNTR MVMT status. Pls change “Status Change” of COP from “NO” to “YES” to update the BKG.
							// S/O of containers have been created already. Pls check the S/O of this booking in advance.
							errMSg = "PRD00079";
						}
					}
					
					if( dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y") || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
						log.debug("\n\n PRD log On:");
						Map map = new HashMap();

						map.put("PrdCreateParamVO", prdCreateParamVO);
						map.put("errCd", errCd);
						map.put("orgPctlNo", orgPctlNo);
						map.put("orgPctlSeq", orgPctlSeq);
        				// CHM-201108922 - [PRD] MVMT / SO validation 에 대한 오류 팝업 메세지 내용 변경 요청
						map.put("errTp", errTp);
						map.put("errSoBnd", errSoBnd);
						map.put("errMvmtBnd", errMvmtBnd);

						
						String logDesc =  this.getParamString(map);
						log.debug("\n\n log::::"+logDesc );
						dbDao.createPrdExecEnisLog(logDesc ,"checkReplan", "");
					}
					
					log.debug("\n replan 채크:Replan 을 할수 없는 상태 ! :  "+errMSg);
					throw new EventException( (errMSg.equals("PRD00014")? "": ((new ErrorHandler(errMSg)).getMessage() +" #@ " ))+ (new ErrorHandler("PRD00014")).getMessage() );
				}			
			//CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청 변경
				dbR=null;
				dbR = dbDao.checkQtyReplan(prdCreateParamVO.getCntrTpszQtyStr() ,prdCreateParamVO.getBkgNo() ,prdCreateParamVO.getFlexHgtFlg());
				if(dbR.next()) {
					String result = dbR.getString("RESULT");
					if( !result.equals(PrdConstants.PRD_REPLAN_QTY_CHK_RESULT_OK) ) {
						// error: 컨테이너 수량변경을 할수 없습니다.
						if( dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y") || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
							log.debug("\n\n PRD log On:");
							Map map = new HashMap();
							map.put("exec result", result); 
							map.put("PrdCreateParamVO", prdCreateParamVO);

							String logDesc =  this.getParamString(map);
							log.debug("\n\n log::::"+logDesc );
							dbDao.createPrdExecEnisLog(logDesc ,"checkQty", "");
						}
						//20081216 add jsy , PRD00056: The Container's Q'ty between BKG and COP is different.
						throw new EventException( (new ErrorHandler("PRD00056")).getMessage()  );
					}
					
				} 
			}
			else {
				//ERROR 
				log.debug("\n REPLAN 할 데이터 가 없습니다.");
				throw new EventException( (new ErrorHandler("PRD00015")).getMessage()  );
			}
			
			
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}


//	/**
//	 * @param e
//	 * @throws EventException
//	 */
//	private void soConnectRouteCheck(Event e) throws EventException {
//		// TODO Auto-generated method stub
//		EsdPrd0080Event event = (EsdPrd0080Event)e;
//		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
//		DBRowSet dbR = null; 
//		boolean retChk = true;
//		try {
//			dbR = dbDao.getSoSubRout(prdCreateParamVO.getBkgNo());
//			while (dbR.next()) {
//				
//				retChk = retChk && dbDao.soConnectRouteCheck(e,dbR.getString("SUB_ROUT"));
//			}
//		} catch (DAOException e1) {
//			log.error("err " + e1.toString(), e1);
//			throw new EventException(new ErrorHandler(e1).getMessage());
//		} catch (SQLException e2) {
//			log.error("err " + e2.toString(), e2);
//			throw new EventException(new ErrorHandler(e2).getMessage());
//		}
//		
//	}

	/**
	 * @param PrdParameterVO prdParameterVO
	 * @param SignOnUserAccount account
	 * @param List<String> cntrList Split Booking중 해당 Booking에 연결될 Container List
	 * @param int splitSeq
	 * @param List<String> bkgNoList Split과 관련된 Booking List
	 * @return String
	 * @throws EventException
	 */
	private String createBkgSplitVvd(PrdParameterVO prdParameterVO, SignOnUserAccount account, List<String> cntrList, int splitSeq, List<String> bkgNoList) throws EventException {
		PrdMainInfoVO prdMainInfoVO = prdParameterVO.getPrdMainInfoVO();

		String mapgSeq = "";
		StringBuilder succSum = new StringBuilder(); // for log
		
		try {
			boolean successFlag = false;
			String cntrTpszQtyStr = null;
			StringBuilder cntrSum = new StringBuilder();
			StringBuilder bkgNoSum = new StringBuilder();
			StringBuilder sbAdjQtyStr = new StringBuilder();
			StringBuilder sbSplitQtyCntStr = new StringBuilder();
			
			// PRD_BKG_COP_MAP_SEQ sequence를 얻는다.
			mapgSeq = dbDao.getPrdBkgCopMapSeq();
			String memoFlag ="";
			if(bkgNoList !=null){
			   memoFlag = bkgNoList.contains(prdMainInfoVO.getParentBkgNo()) ? "0": "1"; // 원본 부킹이 넘겨받은 부킹리스트에 없어야 메모 = 1.
			}
			
			
			//  소스보안 처리를 위해 null 체크 if문 추가
			if(cntrList == null){
				for(int i=0, size = 0; i < size; i++){
					cntrSum.append(cntrList.get(i)).append(", ");
				}
			}else{
				for(int i=0, size = cntrList.size(); i < size; i++){
					cntrSum.append(cntrList.get(i)).append(", ");
				}				
			}
			
			//  소스보안 처리를 위해 null 체크 if문 추가
			if(bkgNoList == null){
				for(int i=0, size = 0 ; i < size; i++){
					bkgNoSum.append(bkgNoList.get(i)).append(",");
				}
			}else{
				for(int i=0, size = bkgNoList.size(); i < size; i++){
					bkgNoSum.append(bkgNoList.get(i)).append(",");
				}			
			}			
			
	
			if (memoFlag.equals("1")) { // split booking에도 parent bkg_no가 들어가야 한다.
				bkgNoSum.append(prdMainInfoVO.getParentBkgNo());
			}

			// if parent booking의 경우 -> bkg_prd_cop_map을 1세트 복사한다.
			if (prdMainInfoVO.getBkgNo().equals(prdMainInfoVO.getParentBkgNo())) {
				// Transaction이 보장되지 않으므로, sce_cop_hdr에 parent를 제외한 bkg가 있을 경우 에러 처리
				if(!dbDao.checkBeforeBkgSplit(prdMainInfoVO.getBkgNo(), bkgNoSum.toString())) {
					// throws exception
					String[] msg = new String[]{prdMainInfoVO.getBkgNo()};
					throw new EventException(new ErrorHandler("PRD00080", msg).getMessage());
				}
				dbDao.updatePrdMapInit(prdMainInfoVO.getBkgNo(), bkgNoSum.toString());
				dbDao.createBkgSplitMapBase(prdMainInfoVO.getBkgNo(), mapgSeq);
			}
			
			// if !(parent booking &&  memo)
			if (!(prdMainInfoVO.getBkgNo().equals(prdMainInfoVO.getParentBkgNo()) && memoFlag.equals("1"))) {
				
				//     Current가 Y이면서 Container가 있는 Booking에 대해 데이터 복구, 다른 booking에서 가져갔을 경우 C로 생성(partial)
				successFlag = dbDao.createBkgSplitMapCntr(prdMainInfoVO, mapgSeq, cntrSum.toString(), bkgNoSum.toString());
				succSum.append("createBkgSplitMapCntr [").append(successFlag).append("]\n");

				// SPLIT BOOKING의 BKG_QUANTITY에 대응하는 정보를 D4@4@BKG,D5@6@SO 형식으로 만든다.
				List<PrdQtyInfoVO> prdQtyInfoVOList = prdParameterVO.getPrdQtyInfo();

				PrdQuantityVO[] prdQuantityVOs = new PrdQuantityVO[prdQtyInfoVOList.size()]; 
				if (prdQtyInfoVOList.size() > 0) {
					for (int i = 0; i < prdQtyInfoVOList.size(); i ++) {
						prdQuantityVOs[i] = new PrdQuantityVO();
						prdQuantityVOs[i].setCTpsz(((PrdQtyInfoVO) prdQtyInfoVOList.get(i)).getCTpsz());
						prdQuantityVOs[i].setCQty(((PrdQtyInfoVO) prdQtyInfoVOList.get(i)).getCQty());
					}
				}
				cntrTpszQtyStr = this.getReplanCntrTpszQty(prdMainInfoVO.getBkgNo() , prdQuantityVOs);

				// 수정 또는 추가되어야할 , 작업 qty를 확인한다.
				DBRowSet rowset = dbDao.searchBkgSplitQtyCount(prdMainInfoVO.getParentBkgNo() ,prdMainInfoVO.getBkgNo(),mapgSeq, null ,cntrTpszQtyStr ); // flexHgtFlg, cntrTpszQty가 null이면 Database에 저장되어 있는 정보를 이용하여 처리한다. Park Mangeon
				
				// QTY 값으로 작업 처리한다.
				// 양수(+)인 경우 X로 만든 데이터를 살리거나, 새로운 데이터를 추가해야 하는 경우이다.
				// 음수(-)인 경우, 남은 데이터중 COP가 없는 데이터중 수량에 맞게 삭제해야 한다. (booking split시 이런 경우가 원래 발생하면 안된다.) Exception 처리여부 업무결정 필요
				
				log.debug(" ************************************************************ ");
				log.debug(" ************ BOOKING SPLIT ADJUSTMENT QTY ****************** ");
				log.debug(" CNTR_TPSZ_CD, BKG_QTY, PC_QTY, MOV_QTY, CALC_QTY, QTY(작업) ");
				
				boolean bFirst = true;
				while(rowset.next()){
					log.debug(rowset.getString("cntr_tpsz_cd") + ", " 
							   + rowset.getString("bkg_qty") + ", "  
							   + rowset.getString("pc_qty") + ", "  
							   + rowset.getString("mov_qty") + ", "  
							   + rowset.getString("calc_qty") + ", "  
							   + rowset.getString("qty"));
					if (!bFirst) {
						sbAdjQtyStr.append(",");
					}
					sbAdjQtyStr.append(rowset.getString("cntr_tpsz_cd")).append("@").append(rowset.getString("qty"));
					sbSplitQtyCntStr.append(" : cntr_tpsz_cd[").append(rowset.getString("cntr_tpsz_cd")).append("]");
					sbSplitQtyCntStr.append(" : bkg_qty[").append(rowset.getString("bkg_qty")).append("]");
					sbSplitQtyCntStr.append(" : pc_qty[").append(rowset.getString("pc_qty")).append("]");
					sbSplitQtyCntStr.append(" : mov_qty[").append(rowset.getString("mov_qty")).append("]");
					sbSplitQtyCntStr.append(" : calc_qty[").append(rowset.getString("calc_qty")).append("]");
					sbSplitQtyCntStr.append(" : qty[").append(rowset.getString("qty")).append("]\n");
					bFirst = false;
				}
				log.debug(" ************************************************************ ");
				log.debug(" result [" + splitSeq + "]" + prdMainInfoVO.getBkgNo() + "[" + sbAdjQtyStr.toString() +"]" );
				log.debug(" ************************************************************ ");
				
				//     qty 부족이 있을 경우, 복원되지 않은 HJCU0000000을 복구하여 N(bkg_no = parent_bkg_no)또는 B(bkg_no <> parent_bkg_no)로 처리하고, 모자라는 것은 C처리
				//     createBkgSplitMapAdj
				if (!bFirst) { // adjust할 게 없으면 처리하지 않는다.
					successFlag = dbDao.createBkgSplitMapAdj(prdMainInfoVO, sbAdjQtyStr.toString(), mapgSeq, bkgNoSum.toString());
					succSum.append("createBkgSplitMapAdj [").append(successFlag).append("]\n");
				}
			}

			if( ( dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y") ) || 
					dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					
				log.debug("\n\n PRD log On:");
				Map map = new HashMap();
				
				map.put("successFlag", successFlag);
				map.put("succSum", succSum.toString());
				
				map.put("bkgNo", prdMainInfoVO.getBkgNo()); //bkg정보 
				map.put("ParentBkgNo", prdMainInfoVO.getParentBkgNo());
				map.put("memoFlag", memoFlag);
				map.put("cntrSum", cntrSum);
				map.put("splitSeq", splitSeq);
				map.put("bkgNoList", bkgNoList);
				// 조정 정보를 포함하여 저장하기 위해서 아래와 같이 처리한다.
				map.put("cntrTpszQtyStr", cntrTpszQtyStr);
				map.put("sbAdjQtyStr", sbAdjQtyStr.toString());
				
				String logDesc =  this.getParamString(map);
				log.debug("\n\n log::::"+logDesc );
				dbDao.createPrdExecEnisLog(logDesc ,"createBkgSplitVvd_1", account.getUsr_id());
			}
			
			// 맨 마지막 Booking에서 Split, Memo중 살아있는 COP를 첫번째 Booking에 몰아주기 한다.
			if(bkgNoList!=null){
				if (prdMainInfoVO.getBkgNo().equals(bkgNoList.get(bkgNoList.size() -1))) {
					// 첫번째 부킹번호를 찾는다.
					String firstBkgNo = bkgNoList.get(0);
					// Container 번호가 없는 유효한 SO가 있는 경우에만 살린다.
					successFlag = dbDao.createBkgSplitMapCopAdj(prdMainInfoVO.getParentBkgNo(), firstBkgNo, mapgSeq);
				}
			}
		
		} catch(DAOException ex){
			if (ex.getMessage() != null && ex.getMessage().indexOf("ORA-00054") != -1) {
				throw new EventException(new ErrorHandler("PRD00080").getMessage(), ex);
			} else {
				throw new EventException(ex.getMessage(), ex);
			}
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("\n\n createBkgSplitVvd return :"+prdMainInfoVO.getBkgNo()+"|"+mapgSeq);
		return prdMainInfoVO.getBkgNo()+"|"+mapgSeq;
		
	}
	

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private String createBkgCopyVvdUnchange(Event e) throws EventException {
		// TODO Auto-generated method stub
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		SignOnUserAccount account = (SignOnUserAccount)e.getAttribute("account"); 
		/*
		 * pc를 copy한다.
		 */
		
		// pc no 생성 
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen( prdCreateParamVO.getPcMode());
		
 
		// pc return value object create
		PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
		// pc_no_head set		
		prdPcCreateVo.setHdPctlNo(hdPctlNo);
		prdPcCreateVo.setIdaHlgTpCd(prdCreateParamVO.getIdaHlgTpCd());
		
		event.setPrdPcCreateVO(prdPcCreateVo);
		int copyCnt = Integer.parseInt(prdCreateParamVO.getCopyCnt());
		DBRowSet rowSet = null;
		try {
			
//			rowSet = dbDao.checkBkgCopy (prdCreateParamVO.getBkgPctlNo() );
			rowSet = dbDao.checkBkgCopy (prdCreateParamVO.getBkgNo());
			
			String bkgPctlNo ="";
			if(!rowSet.next()){
				throw new EventException( (new ErrorHandler("PRD00015")).getMessage()  );
			} else {
				String outB = rowSet.getString("out_b");
				String inB = rowSet.getString("in_b");
				bkgPctlNo = rowSet.getString("pctl_no");
				
				log.debug(" outB:"+outB+" inB:"+inB);
				if(outB.equals("X")) {
					throw new EventException((new ErrorHandler("PRD00026")).getMessage()   );
				}
				if(inB.equals("X")) {
					throw new EventException((new ErrorHandler("PRD00027")).getMessage()   );
				}
				
			}
			
//			// prd mst,dtl 생성
			for (int i = 1; i <= copyCnt; i++) {
				dbDao.createBkgCopyPrdMstVvdUnchange (bkgPctlNo, hdPctlNo , prdCreateParamVO.getScOfc(), prdCreateParamVO.getRfaOfc(), account.getUsr_id(), i, prdCreateParamVO.getSc(), prdCreateParamVO.getRfa() );
				dbDao.createBkgCopyPrdDtlVvdUnchange (bkgPctlNo, hdPctlNo , account.getUsr_id(), i );
				dbDao.createBkgCopyPrdActGrpDtlVvdUnchange (bkgPctlNo, hdPctlNo , prdCreateParamVO.getScOfc(), prdCreateParamVO.getRfaOfc(), account.getUsr_id(), i );
				dbDao.updateBkgCopyVndr ( hdPctlNo ,  i );
				//20091115 추가 
				dbDao.createBkgCopyPrdQtyVvdUnchange (bkgPctlNo, hdPctlNo ,  i );
				if((  dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					
					map.put("PrdCreateParamVO", prdCreateParamVO);
					map.put("PrdPcCreateVO", prdPcCreateVo);
					map.put("bkgPctlNo", bkgPctlNo);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());
					
					String logDesc =  this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					dbDao.createPrdExecEnisLog(logDesc ,"createPrdCtlgFullRout", account.getUsr_id());
				}
			}
			
			String sc_cust_cnt_cd ="";
			String sc_cust_seq ="";
			if(prdCreateParamVO.getSc().length()>2){
				 sc_cust_cnt_cd = prdCreateParamVO.getSc().substring(0,2);
				 sc_cust_seq = prdCreateParamVO.getSc().substring(2);				
			}
			//TODO  coa_bkg_info 테이블 없어짐.
//			prdCreateManageBc.updateSpcAloc(hdPctlNo+"0001" ,sc_cust_cnt_cd,sc_cust_seq);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		log.debug("\n\n createBkgCopyVvdUnchange return :"+hdPctlNo+"0001");
		
		
		return hdPctlNo+"0001";
	}
	
	/**
	 * @param minPctlNo
	 * @return 
	 * @throws EventException
	 */
	public String selectReturnStrToBkg(String minPctlNo) throws EventException {
		DBRowSet rowSet = null;
		String returnPrd ="";
		try {
			rowSet = dbDao.selectReturnStrToBkg(minPctlNo);
			 String mtPuCy ="";
			 String mPuDt ="";
			 String flRtCy ="";
			 String flPuCy ="";
			 String doorDt ="";
			 String loadDt ="";
			 String delDt ="";
			 String obMode ="";
			 String ibMode ="";
			 String porN ="";
			 String delN ="";
			 String mtRtnCy ="";
			 String pcNo ="";
			 String vvd = "";
			 int cnt = 1;
			 while(rowSet.next()){
 
				 if(rowSet.getString("VVD_GB").equals("T") ) {
					 
					 vvd = rowSet.getString("VVD");
 
					 returnPrd=returnPrd+"@*VVD"+cnt+"="+rowSet.getString("VVD")
								                     +"@*POL"+cnt+"="+rowSet.getString("ORG_NOD_CD")
								                     +"@*ETD"+cnt+"="+rowSet.getString("ETD")
								                     +"@*POD"+cnt+"="+rowSet.getString("DEST_NOD_CD")
								                     +"@*ETB"+cnt+"="+rowSet.getString("ETB")
								                     +"@*LAN"+cnt+"="+rowSet.getString("VSL_SLAN_CD")
								                     +"@*MODE"+cnt+"="+rowSet.getString("PCTL_WTR_DIV_CD")
								                     +"@*TRUNK_FLG"+cnt+"="+(vvd.equals(rowSet.getString("T_VVD"))? "Y":"")
								                     +"@*GE"+cnt+"="+rowSet.getString("GEN_AVAL_SPC")
								                     +"@*D7"+cnt+"="+rowSet.getString("D7_AVAL_SPC")
								                     +"@*RF"+cnt+"="+rowSet.getString("RF_AVAL_SPC");
					 
					 log.debug("\n\n GEN:"+rowSet.getString("GEN_AVAL_SPC"));
					 cnt++;
				 }

				 if(rowSet.getString("LOC").equals("RTN CY") ) {
					 mtRtnCy  = rowSet.getString("NODE_LINK");
				 }  
				 if(rowSet.getString("MTY_YD_FLG").equals("Y") && rowSet.getString("PCTL_SEQ").equals("1")) {
					 mtPuCy = rowSet.getString("NODE_LINK");
					 mPuDt  = rowSet.getString("ETB");
				 }
				 if( rowSet.getString("PCTL_SEQ").equals("1")) {
					 porN   = rowSet.getString("ROUT_ORG_NOD_CD");
					 pcNo   = rowSet.getString("PCTL_NO");
				 }
				 
				 if(rowSet.getString("DOOR_DT").equals("Y") ) {
					 doorDt  = rowSet.getString("ETD");
				 }   
				 if(rowSet.getString("MTY_YD_FLG").equals("N") ) {
					 delDt  = rowSet.getString("DELIVERY_DT");
				 } 	
				 obMode  = rowSet.getString("O_T_MODE");
				 ibMode  = rowSet.getString("I_T_MODE");
				 
				 if(rowSet.getString("PCTL_SEQ").equals(rowSet.getString("LOAD_DT_PCTL_SEQ") ) ) {
					 loadDt  = rowSet.getString("ETD");
				 } 
				 
				 flRtCy  = rowSet.getString("NODE_LINK");
				 
//				 if(rowSet.getString("PCTL_SEQ").equals(rowSet.getString("FL_PU_CY_PCTL_SEQ") ) ) {
			     flPuCy  = rowSet.getString("NODE_LINK");
//				 } 
				 delN   = rowSet.getString("ROUT_DEST_NOD_CD");
			 } //while
			 
			 returnPrd="PCNo="+pcNo+returnPrd+ "@*MT_PU_CY="+mtPuCy+"@*M_PU_DT="+mPuDt+"@*FL_RT_CY="+flRtCy
			 				+"@*FL_PU_CY="+flPuCy+"@*DOOR_DT="+doorDt+"@*LOAD_DT="+loadDt+"@*DEL_DT="+delDt
			 				+"@*OB_MODE="+obMode+"@*IB_MODE="+ibMode+"@*POR_N="+porN+"@*DEL_N="+delN+"@*MT_RTN_CY="+mtRtnCy;
//			 				+"@*CUT_OFF_TM="+cutOff+"@*RD_AVL_RTN_TM="+rtnTime;
			 log.debug("\n\n returnAutoPrd1=["+returnPrd+"]");			
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return returnPrd;
	}
	
	/**
	 * PC생성 로직  
	 * BKG의 pc생성로직과 BKG에서 PC가 1개이상 생겨 화면용PC를 만들기 위해 호출.
	 * 즉,BKG 에서 PC생성을 위해 호출시 모두 사용.  
	 * 1.bkg에서 method call시에도 사용.
	 * 2.url 호출시도 사용. 
	 * 
	 * 3.prd inquery 에서도 호출 
	 * @param e
	 * @throws EventException
	 */
	public void createPrdCtlgFullRout(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		SignOnUserAccount account = (SignOnUserAccount)e.getAttribute("account"); 
		PrdPatternVO prdPatternVO = null;
		int successFlag = 0;
		// pc no 생성 
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen( prdCreateParamVO.getPcMode());
		
		// pc return value object create
		PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
		// pc_no_head set		
		prdPcCreateVo.setHdPctlNo(hdPctlNo);
		prdPcCreateVo.setIdaHlgTpCd(prdCreateParamVO.getIdaHlgTpCd());
		
		String skdType = prdCreateParamVO.getInternalSkdType();
		
		if(!"L".equals(skdType)){
		//skdType(L,V) 찾음.
			skdType = prdCreateManageBc.getSkdType( prdCreateParamVO.getTVvd(),prdCreateParamVO.getLdDt(), prdCreateParamVO.getPol1());
		}
		//skdType(L,V) 셋팅, skdDate 셋팅.
		prdPcCreateVo.setSkdType(skdType);

		log.debug("\n\n ========= "+ prdPcCreateVo.getSkdType());
		//skdDate 셋팅. (date, vvd)
		if(skdType.equals("L") ){
			if(prdCreateParamVO.getInternalSkdType()!= null &&  !prdCreateParamVO.getInternalSkdType().equals("")
					&& prdCreateParamVO.getLdDt().equals("")){
 				prdCreateParamVO.setLdDt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
			}
			// skd function 에서 skd_date를 date 또는 vvd를 사용하므로 셋팅해준다.
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getLdDt());
		}else {
			// skd function 에서 skd_date를 date 또는 vvd를 사용하므로 셋팅해준다.
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getTVvd());
		}
		
		event.setPrdPcCreateVO(prdPcCreateVo);

		try {
//			// prd mst,dtl 생성

			if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_N)){ 
				successFlag = dbDao.createProductCatalogInternalTemp(prdCreateParamVO, prdPcCreateVo, account.getUsr_id());
			}else if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_T)){
				if("".equals(prdCreateParamVO.getPol())){ // PRS > COA 용
					successFlag = dbDao.createProductCatalogIncludeReplanePRS(prdCreateParamVO, prdPcCreateVo, account.getUsr_id());
				}else{
					successFlag = dbDao.createProductCatalogIncludeReplane(prdCreateParamVO, prdPcCreateVo, null, skdType);
//					successFlag = dbDao.createProductCatalogIncludeReplane(prdCreateParamVO, prdPcCreateVo, prdPatternVO, skdType);
				}
				//successFlag = dbDao.createProductCatalogInternal(e , account.getUsr_id(), PrdConstants.PRD_PC_MOD_T );
			}else if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_REPLAN)) {
				List list = (List)event.getAttribute("PATTERN_LIST");
				
//				for(int i=0; i<list.size(); i++){
				if(list != null && list.size()>0){
					//ord= 1인 주패턴으로 pc를 생성한다.
					//리플랜시 선택버튼을 클릭할때는 주패턴이 빠진 list를 가지고 처리함.
					//pc가 1개이상 생길수 있으므로 뒷단에서 주패턴 PC의 ocn route를 가진 pc를 찾아 pc no로 업데이트한다.
					prdPatternVO = (PrdPatternVO)list.get(0);
				}
				//pc mst, dtl 생성.
				successFlag = dbDao.createProductCatalogIncludeReplane(prdCreateParamVO, prdPcCreateVo, prdPatternVO, account.getUsr_id() );
				log.debug("\n\n createPrdCtlgFullRout pc생성successFlag: "+successFlag);
				
				if((successFlag == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					
					map.put("PrdCreateParamVO", prdCreateParamVO);
					map.put("PrdPcCreateVO", prdPcCreateVo);
					map.put("PrdPatternVO", prdPatternVO);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());
					
					String logDesc = "successFlag " + Integer.toString(successFlag) + " " + this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					dbDao.createPrdExecEnisLog(logDesc ,"createPrdCtlgFullRout", account.getUsr_id());
				}
				// PC 화면에서 호출시 MT PU DATE 체크 
				// N개의 PC생성시 MT PU DATE가 맞지 않으면 제외 하고, 나머지는 입력된 MT PU DATE로 업데이트 
				// MT PU DATE 가 입력되었을때 입력값이  SKD보다 뒤이면  EXCEPTION 
				// 입력값이 SKD DATE보다 앞이면 입력값으로 SKD을 변경.
				//1.MST PC갯수 확인 
				//2.해당 갯수 만큼 LOOP 돌면서 체크
				log.debug("\n getRcvT():["+prdCreateParamVO.getRcvT() +"], getMtPkupDt():["+prdCreateParamVO.getMtPkupDt()+"]");
				if( !prdCreateParamVO.getRcvT().equals("S") && prdCreateParamVO.getMtPkupDt()!= null && !prdCreateParamVO.getMtPkupDt().equals("") ){
					List prdMstList = dbDao.selectPrdMstByHdPctlNO(hdPctlNo);
					int prdMstCnt = prdMstList.size();
					
					int i= 0;
					// pc가 2개 이상일때만 (prdMstCnt>1) 
					// pc가 1개 일때도 처리 하게 (20100125)
					int deleteCnt =0;
					while (prdMstCnt>=1 && i < prdMstCnt){
						PrdProdCtlMstVO prdProdCtlMstVO  = (PrdProdCtlMstVO)prdMstList.get(i);
						
						// dtl 은  delete하고 mst 는 mode를 'X'로 업데이트 한다.
						// pc가 모두 지워지면 메세지를 띄운다.
						if( !checkMtPkupDt( prdProdCtlMstVO.getPctlNo(),prdCreateParamVO.getMtPkupDt()) ) {
//							throw new EventException(" Mt PkUp Date invalid!");
							int successsFlgMt = dbDao.updatePrdDtlByMtPuDtValidate( prdProdCtlMstVO.getPctlNo() ,prdCreateParamVO.getMtPkupDt() );
							log.debug("\n\n updatePrdDtlByMtPuDtValidate  successFlag: "+successsFlgMt);
							
							successsFlgMt = dbDao.updatePrdMstByMtPuDtValidate( prdProdCtlMstVO.getPctlNo() );
							log.debug("\n\n updatePrdMstByMtPuDtValidate  successFlag: "+successsFlgMt);
							deleteCnt ++;
						}else {
							// mt dt 를 변경해준다. 
							setMtPkupDt(prdProdCtlMstVO.getPctlNo(), prdCreateParamVO.getMtPkupDt());						
						}
						i++;
					}
					log.debug("\n\n\n pc생성개수와 delete된 개수가 같으면 exception 발생.-------------" +
							"\n prdMstCnt:"+prdMstCnt+
							"\n deleteCnt:"+deleteCnt+
							"\n-------------------------------------------------------------------\n\n");
					//pc생성개수와 delete된 개수가 같으면 exception 발생.
					if(prdMstCnt>=1 &&  prdMstCnt==deleteCnt){
//						throw new EventException(new ErrorHandler(" Mt PkUp Date invalid!").getMessage());
						throw new EventException(new ErrorHandler("PRD00058").getMessage());
					}
				}					
				
				
				
			}else{  //일반 PC생성일떄 (B)

				successFlag = dbDao.createProductCatalogIncludeReplane(prdCreateParamVO, prdPcCreateVo, prdPatternVO, account.getUsr_id() );
				if((successFlag == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					
					map.put("PrdCreateParamVO", prdCreateParamVO);
					map.put("PrdPcCreateVO", prdPcCreateVo);
					map.put("PrdPatternVO", prdPatternVO);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());
					
					String logDesc = "successFlag " + Integer.toString(successFlag) + " " + this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					dbDao.createPrdExecEnisLog(logDesc ,"createPrdCtlgFullRout", account.getUsr_id());
				}
				
				// PC 화면에서 호출시 MT PU DATE 체크 
				// N개의 PC생성시 MT PU DATE가 맞지 않으면 제외 하고, 나머지는 입력된 MT PU DATE로 업데이트 
				// MT PU DATE 가 입력되었을때 입력값이  SKD보다 뒤이면  EXCEPTION 
				// 입력값이 SKD DATE보다 앞이면 입력값으로 SKD을 변경.
				//1.MST PC갯수 확인 
				//2.해당 갯수 만큼 LOOP 돌면서 체크
				log.debug("\n getRcvT():["+prdCreateParamVO.getRcvT() +"], getMtPkupDt():["+prdCreateParamVO.getMtPkupDt()+"]");				
				log.debug("\n\n  %%%%%%%  prdCreateParamVO.getMtPkupDt(): "+prdCreateParamVO.getMtPkupDt());
				if( !prdCreateParamVO.getRcvT().equals("S") &&  prdCreateParamVO.getMtPkupDt()!= null 
						&& !prdCreateParamVO.getMtPkupDt().equals("") ){
					List prdMstList = dbDao.selectPrdMstByHdPctlNO(hdPctlNo);
					int prdMstCnt = prdMstList.size();
					log.debug("\n\n  %%%%%%%  prdMstCnt: "+prdMstCnt);
					
					int i= 0;
					int deleteCnt =0;
					// pc가 2개 이상일때만 (prdMstCnt>1)
					// pc가 1개 일때도 처리 하게 (20100125)
					while (prdMstCnt>=1 && i < prdMstCnt){
						PrdProdCtlMstVO prdProdCtlMstVO  = (PrdProdCtlMstVO)prdMstList.get(i);
						log.debug("\n\n  %%%%%%%  getPctlNo: "+prdProdCtlMstVO.getPctlNo());
						if( !checkMtPkupDt( prdProdCtlMstVO.getPctlNo(),prdCreateParamVO.getMtPkupDt()) ) {
//							throw new EventException(" Mt PkUp Date invalid!");
							//dtl delete 
							int successsFlgMt = dbDao.updatePrdDtlByMtPuDtValidate( prdProdCtlMstVO.getPctlNo() ,prdCreateParamVO.getMtPkupDt() );
							log.debug("\n\n updatePrdDtlByMtPuDtValidate  successFlag: "+successsFlgMt);
 							// pc mode를 X로 업데이트 
							successsFlgMt = dbDao.updatePrdMstByMtPuDtValidate( prdProdCtlMstVO.getPctlNo() );
							log.debug("\n\n updatePrdMstByMtPuDtValidate  successFlag: "+successsFlgMt);
							deleteCnt ++;

						} else {
							// mt dt 를 변경해준다. 
							setMtPkupDt(prdProdCtlMstVO.getPctlNo(), prdCreateParamVO.getMtPkupDt());						
						}
						i++;
					}	
					log.debug("\n\n\n pc생성개수와 delete된 개수가 같으면 exception 발생.-------------" +
							"\n prdMstCnt:"+prdMstCnt+
							"\n deleteCnt:"+deleteCnt+
							"\n-------------------------------------------------------------------\n\n");
					//pc생성개수와 delete된 개수가 같으면 exception 발생.
					if(prdMstCnt>=1 &&  prdMstCnt==deleteCnt){
//						throw new EventException(new ErrorHandler(" Mt PkUp Date invalid!").getMessage());
						throw new EventException(new ErrorHandler("PRD00058").getMessage());
					}
				}	
				
			}

		
			//PC생성시 에러는 없고 PC가 만들어지지 않았을때
			if(successFlag <= 0){
				event.setAttribute("prdPatternVO", prdPatternVO);
				
				//pc create fail 메세지를 SC에서 확인해서 VERIFY CHECK 를 해서 메세지를 보여준다.
				throw new EventException( (new ErrorHandler("PRD00074")).getMessage() );
			}

//			// Auto IRG를 생성해야하는지 검사하고, 필요시 생성한다. 20100713
//			prdCreateManageBc.createAutoIRG(prdPcCreateVo.getHdPctlNo(), account.getUsr_id(), account.getOfc_cd());
			
//			
//			// qty 생성
			prdCreateManageBc.createContainerQty(e);
//			
//			// data 정리 (min, max pc no )
			prdCreateManageBc.dataArrangement(e);
//			
			log.debug("\n\n -------------dataArrangement 종료----------------------");
			
//			// activity group dtl 생성
//			prdCreateManageBc.createActivityGroup(e);
			prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo,prdPatternVO,account.getUsr_id() );
			
			
			log.debug("\n\n -------------createActivityGroup 종료----------------------");
//			
//			// activity group dtl update
			prdCreateManageBc.updateActivityGroup(hdPctlNo);
			
			log.debug("\n\n -------------createActivityGroup 종료----------------------");
			

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * @param e
	 * @throws EventException
	 */
//	public void updateContainerQtyforPreCm(Event e) throws EventException {
//		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
//		try {
////			// qty 생성
//			prdCreateManageBc.createContainerQty(e);
//			
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//	}	
	
	
	/**
	 * @param pctlNo
	 * @param mtPkupDt
	 * @return
	 * @throws EventException
	 */
	private boolean checkMtPkupDt(String pctlNo, String mtPkupDt) throws EventException{
		DBRowSet dbR = null;
		boolean returnVal = true;
		try {
			dbR =dbDao.checkMtPkupDt(pctlNo, mtPkupDt );
			if(dbR.next()){
				if(dbR.getString("CHECK_MT_PU").equals("OK")) {
					log.debug("\n\ncheckMtPkupDt:OK");
					returnVal = true;
				} else {
					log.debug("\n\ncheckMtPkupDt:Exception");
					returnVal = false;

				}
			}

		} catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return returnVal ;
	}

	/**
	 * @param pctlNo
	 * @param mtPkupDt
	 * @throws EventException
	 */
	private void setMtPkupDt(String pctlNo, String mtPkupDt) throws EventException{
		int ret = 0;
		try {
			ret =dbDao.setMtPkupDt(pctlNo, mtPkupDt );
			log.debug("\n setMtPkupDt update ret value: "+ret);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	
	/**
	 * @param e
	 * @param prdPatternVO
	 * @throws EventException
	 */
	public void createPrdCtlgIncludeReplane(Event e, PrdPatternVO prdPatternVO) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
 
		SignOnUserAccount account = (SignOnUserAccount)e.getAttribute("account"); 

		// pc no 생성 
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen( prdCreateParamVO.getPcMode());
		
		// pc return value object create (새로 생성)
		PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
		// pc_no_head set		
		prdPcCreateVo.setHdPctlNo(hdPctlNo);
		// Merchant Haulage 처리를 위해 bkg_no 추가
		prdPcCreateVo.setBkgNo(prdCreateParamVO.getBkgNo());
		prdPcCreateVo.setIdaHlgTpCd(prdCreateParamVO.getIdaHlgTpCd());
		
		//skdType(L,V) 찾음.
		String skdType = prdCreateManageBc.getSkdType( prdCreateParamVO.getTVvd(),prdCreateParamVO.getLdDt(), prdCreateParamVO.getPol1());
		
		//skdType(L,V) 셋팅, skdDate 셋팅.
		prdPcCreateVo.setSkdType(skdType);
		
		//skdDate 셋팅. (date, vvd)
		if(skdType.equals("L")){
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getLdDt());
		}else {
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getTVvd());
		}
		
		//새로 생성된 pc결과를 event에 셋팅.
		event.setPrdPcCreateVO(prdPcCreateVo); // 패턴2번째 가 셋팅될수 있다.
		
		try {
			int successCnt = dbDao.createProductCatalogIncludeReplane(prdCreateParamVO, prdPcCreateVo,prdPatternVO, account.getUsr_id() );
			
			if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
				log.debug("\n\n PRD log On:");
				Map map = new HashMap();
				
				map.put("PrdCreateParamVO", prdCreateParamVO);
				map.put("PrdPcCreateVO", prdPcCreateVo);
				map.put("PrdPatternVO", prdPatternVO);
				map.put("usrId", account.getUsr_id());
				
				String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
				log.debug("\n\n log::::"+logDesc );
			
				
//				dbDao.createPrdExecEnisLog(log_desc,app_info);
				dbDao.createPrdExecEnisLog(logDesc ,"createPrdCtlgIncludeReplane", account.getUsr_id());
			}
			//pc생성 실패시 하위로직을 테우지 않는다.
			//부패턴은 계속 처리 해서 뒷단에서 cop_map 테이블에 처리하도록 둔다.
//			if(successCnt <= 0 && !prdPatternVO.getCopPattOrdNo().equals("1")){
//				event.setAttribute("prdPatternVO", prdPatternVO);
//				
//				//pc create fail 메세지를 SC에서 확인해서 VERIFY CHECK 를 해서 메세지를 보여준다.
//				throw new EventException( (new ErrorHandler("PRD00074")).getMessage() );
//			}
			
//			// Auto IRG를 생성해야하는지 검사하고, 필요시 생성한다. 20100713
//			prdCreateManageBc.createAutoIRG(prdPcCreateVo.getHdPctlNo(), account.getUsr_id(), account.getOfc_cd());
			
//			// qty 생성
			prdCreateManageBc.createContainerQty(e);
//			
//			// data 정리 (min, max pc no )
			prdCreateManageBc.dataArrangement(e);
//			
			log.debug("\n\n -------------dataArrangement 종료----------------------");
			
//			// activity group dtl 생성
			prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo,prdPatternVO,account.getUsr_id() );
			
			log.debug("\n\n -------------createActivityGroup 종료----------------------");
//			
//			// activity group dtl update
			prdCreateManageBc.updateActivityGroup(hdPctlNo);
			
			log.debug("\n\n -------------createActivityGroup 종료----------------------");
			

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		
	}

	private String getParamString(Map map) {
		// TODO Auto-generated method stub
		HashMap hMap = (HashMap)map;
		PrdCreateParamVO prdCreateParamVO = null;
		PrdPcCreateVO prdPcCreateVo = null;
		PrdPatternVO prdPatternVO = null;
		PrdSceGetParamVO prdSceGetParamVO = null;
		PrdQtyInfoVO prdQtyInfoVO = null; //split 로그 
		StringBuilder sb = new StringBuilder();
		Map vo1 = new HashMap();

//		if(hMap.containsKey("PrdCreateParamVO")) {
//			prdCreateParamVO =(PrdCreateParamVO) map.get("PrdCreateParamVO");
//			vo1 = prdCreateParamVO.getColumnValues();
//			sb.append("\r▶  prdCreateParamVO ▶ ");
//			sb.append("\r▶  "+vo1.toString());
//			
//		}
//		if(hMap.containsKey("PrdPcCreateVo")) {
//			prdPcCreateVo =(PrdPcCreateVO) map.get("PrdPcCreateVo");
//			vo1 = prdPcCreateVo.getColumnValues();
//			sb.append("\r▶  PrdPcCreateVO ▶ ");
//			sb.append("\r▶  "+vo1.toString());
//			
//		}
//		if(hMap.containsKey("PrdPatternVO")) {
//			prdPatternVO =(PrdPatternVO) map.get("PrdPatternVO");
//			vo1 = prdPatternVO.getColumnValues();
//			sb.append("\r▶  PrdPatternVO ▶ ");
//			sb.append("\r▶  "+vo1.toString());
//		}
		
//		for (int j = 0; j < hMap.size(); j++) {
			Object[] keyL = (Object[])hMap.keySet().toArray();
			for (int i = 0; i < keyL.length; i++) {
				
//				if(hMap.containsKey("PrdCreateParamVO")) {
				String keyS = (String)keyL[i];
				log.debug("n\n\n" +keyS);
				if(((String)keyL[i]).contains("PrdCreateParamVO") ) {
					prdCreateParamVO =(PrdCreateParamVO) map.get((String)keyL[i]);
					sb.append("\r▶"+(String)keyL[i]+" ▶ ");
				    if(prdCreateParamVO ==null){
				    	
				    	sb.append("\r▶  "+ "is NULL");
				    } else {
				    	vo1 = prdCreateParamVO.getColumnValues();
				    	sb.append("\r▶  "+vo1.toString());
				    }
				}else if(((String)keyL[i]).contains("PrdPcCreateVO")) {
					prdPcCreateVo =(PrdPcCreateVO) map.get((String)keyL[i]);
					sb.append("\r▶"+(String)keyL[i]+" ▶ ");
					if(prdPcCreateVo == null ){
						sb.append("\r▶  "+ "is NULL");
					} else {
						vo1 = prdPcCreateVo.getColumnValues();
						sb.append("\r▶  "+vo1.toString());
					}
					
				}else if(((String)keyL[i]).contains("PrdPatternVO")) {
					prdPatternVO =(PrdPatternVO) map.get((String)keyL[i]);
					sb.append("\r▶"+(String)keyL[i]+" ▶ ");
					if(prdPatternVO ==null){
						sb.append("\r▶  "+ "is NULL");
					}else {
						vo1 = prdPatternVO.getColumnValues();
						sb.append("\r▶  "+vo1.toString());
					}
					
				}else if(((String)keyL[i]).contains("PrdSceGetParamVO")) {
					prdSceGetParamVO =(PrdSceGetParamVO) map.get((String)keyL[i]);
				
					sb.append("\r▶"+(String)keyL[i]+" ▶ ");
					if(prdSceGetParamVO ==null){
						sb.append("\r▶  "+ "is NULL");
					}else {
						vo1 = prdSceGetParamVO.getColumnValues();
						sb.append("\r▶  "+vo1.toString());
					}
				}else if(((String)keyL[i]).contains("PrdQtyInfoVO")) {
					prdQtyInfoVO =(PrdQtyInfoVO) map.get((String)keyL[i]);
				
					sb.append("\r▶"+(String)keyL[i]+" ▶ ");
					if(prdQtyInfoVO ==null){
						sb.append("\r▶  "+ "is NULL");
					}else {
						vo1 = prdQtyInfoVO.getColumnValues();
						sb.append("\r▶  "+vo1.toString());
					}				
				} else {
					sb.append("\r▶"+(String)keyL[i]+" ▶ ");
					sb.append(hMap.get((String)keyL[i])==null ? "is Null": hMap.get((String)keyL[i]) );
				}
				
			}
			
//		}
		return sb.toString();
		
	}

	/**
	 * @param e
	 * @param prdSearchEurDrRePatternVO
	 * @param prdPatternVO
	 * @throws EventException
	 */  
	public void createPrdCtlgEurDoor(Event e, PrdSearchEurDrRePatternVO prdSearchEurDrRePatternVO,PrdPatternVO prdPatternVO) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
 
		SignOnUserAccount account = (SignOnUserAccount)e.getAttribute("account"); 
		
		// pc no 생성 
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen( prdCreateParamVO.getPcMode());
		
		PrdSceGetParamVO prdSceGetParamVO = null;
		
		// pc return value object create (새로 생성)
		PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
		// pc_no_head set		
		prdPcCreateVo.setHdPctlNo(hdPctlNo);
		// Merchant Haulage 처리를 위해 cop_no 추가
		prdPcCreateVo.setCopNo(prdSearchEurDrRePatternVO.getCopNo());
		prdPcCreateVo.setIdaHlgTpCd(prdCreateParamVO.getIdaHlgTpCd());
		
		event.setPrdPcCreateVO(prdPcCreateVo);
	
		String obPctlNo =null ;
		String ibPctlNo =null ;
		String ocnPctlNo =null ;
//		String newPctlNo =null ;
		
	    String rePctlNo = null ;
	    
	    String ioBndCd = null ;
	    String doorZn = null ;
	    String fullRtnCy =null ;
		String fullPuCy =null ;
		String mtPu =null ;
		String mtRtn =null ;
		String trspModCd = null;
		String copNo = prdSearchEurDrRePatternVO.getCopNo() ;
		String pcMode = null ;
		String srTerm = null ;
		String sdTerm = null ;
		String cct    = null ;
		String podT   = null ;
		String polT   = null ;	 
//		String spmFlg = "";
//		String srfCntr = prdCreateParamVO.getRfF();
//		String creUsrId = account.getCre_usr_id() ;
//		String pmF = "";
		String inlndRoutOrg = null;
		String inlndRoutDest = null;
//		String sinclShtlSoFlg = null;
		String prdCtlNo = null ;
		String subRout = null ;
		String fullCy = null ;
//		String stermNode = "";
		
		if(prdSearchEurDrRePatternVO.getEurObFlg().equals("Y") 
				&& (prdSearchEurDrRePatternVO.getPolTmlDiffFlg().equals("N")||prdSearchEurDrRePatternVO.getPorTmlDiffFlg().equals("N"))) {
			obPctlNo= prdSearchEurDrRePatternVO.getOldPctlNo();
		} else {
			obPctlNo = prdSearchEurDrRePatternVO.getNewPctlNo();
		}
		if(prdSearchEurDrRePatternVO.getEurIbFlg().equals("Y") 
				&& (prdSearchEurDrRePatternVO.getPodTmlDiffFlg().equals("N")||prdSearchEurDrRePatternVO.getDelTmlDiffFlg().equals("N"))) {
			ibPctlNo = prdSearchEurDrRePatternVO.getOldPctlNo();
		} else {
			ibPctlNo = prdSearchEurDrRePatternVO.getNewPctlNo();
		}
		ocnPctlNo = prdSearchEurDrRePatternVO.getNewPctlNo();
		 
		srTerm = prdSearchEurDrRePatternVO.getBkgRcvTermCd();
		sdTerm = prdSearchEurDrRePatternVO.getBkgDeTermCd();
		cct = prdSearchEurDrRePatternVO.getCct() ;
		podT = prdSearchEurDrRePatternVO.getPodT();
		polT = prdSearchEurDrRePatternVO.getPolT();
    	fullPuCy = prdSearchEurDrRePatternVO.getFullPkupYdCd();
		mtRtn = prdSearchEurDrRePatternVO.getMtyRtnYdCd();
		fullRtnCy = prdSearchEurDrRePatternVO.getFullRtnYdCd();			
		mtPu = prdSearchEurDrRePatternVO.getMtyPkupYdCd();	
		prdCtlNo = prdSearchEurDrRePatternVO.getNewPctlNo();	
	      
		
		//새로 생성된 pc결과를 event에 셋팅.
//		event.setPrdPcCreateVO(prdPcCreateVo);
		
//		try {
		int successCnt = 0;
		
		if(((prdSearchEurDrRePatternVO.getPodTmlDiffFlg().equals("Y") || prdSearchEurDrRePatternVO.getPorTmlDiffFlg().equals("Y")) && prdSearchEurDrRePatternVO.getEurIbFlg().equals("Y"))
				|| ((prdSearchEurDrRePatternVO.getPolTmlDiffFlg().equals("Y") || prdSearchEurDrRePatternVO.getDelTmlDiffFlg().equals("Y")) && prdSearchEurDrRePatternVO.getEurObFlg().equals("Y"))){	
	
			// param set start
		    if(prdSearchEurDrRePatternVO.getEurObFlg().equals("Y") ) {
		    	ioBndCd = "O" ;
		    	pcMode = "O" ;
		    	srTerm = "D" ;
		    	doorZn = prdSearchEurDrRePatternVO.getNewPor() ;
		    	trspModCd =prdSearchEurDrRePatternVO.getObTrspMod();
		    	subRout = prdSearchEurDrRePatternVO.getObContent() ;
		    	fullCy = prdSearchEurDrRePatternVO.getFullRtnYdCd();
		    }  else if (prdSearchEurDrRePatternVO.getEurIbFlg().equals("Y")) {
		    	ioBndCd = "I" ;
		    	pcMode = "I" ;
		    	sdTerm = "D" ;
		    	doorZn = prdSearchEurDrRePatternVO.getNewDel() ;
		    	trspModCd =prdSearchEurDrRePatternVO.getIbTrspMod();
		    	subRout = prdSearchEurDrRePatternVO.getIbContent() ;
		    	fullCy = prdSearchEurDrRePatternVO.getFullPkupYdCd();
		    }
		    
		    List<PrdSceGetParamVO> sceGetParamList = null;
		   
			try {
				sceGetParamList = dbDaoSce.sceGetParam(copNo, ioBndCd, pcMode, doorZn, fullRtnCy, fullPuCy, mtPu, mtRtn );
			} catch (DAOException e1) {
				log.error("err " + e1.toString(), e1);
				throw new EventException(new ErrorHandler(e1).getMessage());
			} 
			
			if(sceGetParamList != null && sceGetParamList.size()>0) {
				
				prdSceGetParamVO = (PrdSceGetParamVO)sceGetParamList.get(0);
				inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getRoutOrgNodCd());
				inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getRoutDestNodCd());
//					sinclShtlSoFlg = JSPUtil.getNull(prdSceGetParamVO.getInclShtlSoFlg());
				
				
				if (ioBndCd !=null && ioBndCd.equals("O")){
					// 소스보안 을 위해 null 체크 if문 추가 
					if(doorZn !=null){
						prdSceGetParamVO.setPorCd(doorZn.substring(0,5));
					}else{
						prdSceGetParamVO.setPorCd("");
					}
					prdSceGetParamVO.setDelCd(prdCreateParamVO.getDel()) ; 
					prdSceGetParamVO.setPorNodCd(doorZn) ;
					prdSceGetParamVO.setDelNodCd(prdCreateParamVO.getDelN()) ;
				}else {
					prdSceGetParamVO.setPorCd(prdCreateParamVO.getPor()) ;
					// 소스보안 을 위해 null 체크 if문 추가 
					if(doorZn !=null){
						prdSceGetParamVO.setDelCd(doorZn.substring(0,5));	
					}else{
						prdSceGetParamVO.setDelCd("");	
					}					
					
					prdSceGetParamVO.setPorNodCd(prdCreateParamVO.getPorN()) ;
					prdSceGetParamVO.setDelNodCd(doorZn) ;
				}
				
				prdSceGetParamVO.setEurCheck("Y");
				
				prdSceGetParamVO.setRcvTermCd(srTerm) ;
				prdSceGetParamVO.setDeTermCd(sdTerm) ; 
				prdSceGetParamVO.setPolCd(prdCreateParamVO.getPol()) ;
				prdSceGetParamVO.setPodCd(prdCreateParamVO.getPod()) ;
				prdSceGetParamVO.setMtPu(mtPu);
				
				prdSceGetParamVO.setFullRtnYdCd(prdSearchEurDrRePatternVO.getFullRtnYdCd()) ;
				prdSceGetParamVO.setFullPkupYdCd(prdSearchEurDrRePatternVO.getFullPkupYdCd()) ; 
				prdSceGetParamVO.setObTrspMode(prdSearchEurDrRePatternVO.getObTrspMod());
				prdSceGetParamVO.setIbTrspMode(prdSearchEurDrRePatternVO.getIbTrspMod());				
				
				prdSceGetParamVO.setOcnBound(prdSearchEurDrRePatternVO.getOcnContent()) ;
				prdSceGetParamVO.setOutBound(prdSearchEurDrRePatternVO.getObContent());
				prdSceGetParamVO.setInBound(prdSearchEurDrRePatternVO.getIbContent());
				
				prdSceGetParamVO.setNewPod(prdSearchEurDrRePatternVO.getNewPod());
				prdSceGetParamVO.setNewPol(prdSearchEurDrRePatternVO.getNewPol());
				prdSceGetParamVO.setN1PolClptSeq(prdSearchEurDrRePatternVO.getN1PolClptSeq()) ;
				prdSceGetParamVO.setN1PodClptSeq(prdSearchEurDrRePatternVO.getN1PodClptSeq()) ;
				prdSceGetParamVO.setN2PolClptSeq(prdSearchEurDrRePatternVO.getN2PolClptSeq()) ;
				prdSceGetParamVO.setN2PodClptSeq(prdSearchEurDrRePatternVO.getN2PodClptSeq()) ;
				prdSceGetParamVO.setN3PolClptSeq(prdSearchEurDrRePatternVO.getN3PolClptSeq()) ;
				prdSceGetParamVO.setN3PodClptSeq(prdSearchEurDrRePatternVO.getN3PodClptSeq()) ;
				prdSceGetParamVO.setN4PolClptSeq(prdSearchEurDrRePatternVO.getN4PolClptSeq()) ;
				prdSceGetParamVO.setN4PodClptSeq(prdSearchEurDrRePatternVO.getN4PodClptSeq()) ;			
				
				prdSceGetParamVO.setVvd1(prdSearchEurDrRePatternVO.getVvd1());
				prdSceGetParamVO.setVvd2(prdSearchEurDrRePatternVO.getVvd2());
				prdSceGetParamVO.setVvd3(prdSearchEurDrRePatternVO.getVvd3());
				prdSceGetParamVO.setVvd4(prdSearchEurDrRePatternVO.getVvd4());
				prdSceGetParamVO.setOrgLocCd(prdSearchEurDrRePatternVO.getOrgLocCd());
				prdSceGetParamVO.setDestLocCd(prdSearchEurDrRePatternVO.getDestLocCd());
				prdSceGetParamVO.setOcnSeq(prdSearchEurDrRePatternVO.getOcnSeq());
				prdSceGetParamVO.setTVvd(prdSearchEurDrRePatternVO.getTVvd());
			}
			// param set end
			
			try {
				successCnt = dbDaoSce.createSceSoReplaneOcnInlndChange(prdSceGetParamVO,hdPctlNo);
				
//				// Auto IRG를 생성해야하는지 검사하고, 필요시 생성한다. 20100713
//				prdCreateManageBc.createAutoIRG(hdPctlNo, account.getUsr_id(), account.getOfc_cd());
				
				if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					
					map.put("PrdSceGetParamVO", prdSceGetParamVO);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());
					
					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					
					dbDao.createPrdExecEnisLog(logDesc ,"createPrdCtlgEurDoor_1", account.getUsr_id());
				}	
			} catch (DAOException e2) {
				log.error("err " + e2.toString(), e2);
				throw new EventException(new ErrorHandler(e2).getMessage());
			} 
		} else {
			try {
				successCnt = dbDao.reCreatePrdForEurDoor(obPctlNo, ibPctlNo, ocnPctlNo, hdPctlNo );
				if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					
					map.put("obPctlNo", obPctlNo);
					map.put("ibPctlNo", ibPctlNo);
					map.put("ocnPctlNo", ocnPctlNo);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());
					
					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					
					dbDao.createPrdExecEnisLog(logDesc ,"createPrdCtlgEurDoor_2", account.getUsr_id());
				}
			} catch (DAOException e3) {
				log.error("err " + e3.toString(), e3);
				throw new EventException(new ErrorHandler(e3).getMessage());
			} 
		}
		
		try {
			rePctlNo= dbDao.searchDirectOcn(prdPcCreateVo.getHdPctlNo());
			
			if(rePctlNo.equals("FAIL")){
				if(ioBndCd!=null){
					// PC가 만들어 지지 않은 경우 BKG에서 BOUND별로 UNCONFIRM 해주는 경우가 아닌 경우만 FAIL 처리함.
					if(ioBndCd.equals("O") && prdSearchEurDrRePatternVO.getObUnconfirmFlg().equals("N") ) {
						successCnt =dbDao.updatePrdMapByPcCreateFail(prdSearchEurDrRePatternVO.getCopPattOrdNo(), event.getAttribute("eur_dr_seq")+"" );	
					
					} else if (ioBndCd.equals("I") && prdSearchEurDrRePatternVO.getIbUnconfirmFlg().equals("N") ) {
						successCnt =dbDao.updatePrdMapByPcCreateFail(prdSearchEurDrRePatternVO.getCopPattOrdNo(), event.getAttribute("eur_dr_seq")+"" );	
					}
				}
				if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					
					map.put("CopPattOrdNo", prdSearchEurDrRePatternVO.getCopPattOrdNo());
					map.put("eur_dr_seq", event.getAttribute("eur_dr_seq"));
 
					map.put("usrId", account.getUsr_id());
					
					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					
					dbDao.createPrdExecEnisLog(logDesc ,"createPrdCtlgEurDoor_mf", account.getUsr_id());
				}
			} else { 
		
				//pc생성 실패시 하위로직을 테우지 않는다.
				//부패턴은 계속 처리 해서 뒷단에서 cop_map 테이블에 처리하도록 둔다.
	
	//			// qty 생성
				prdCreateManageBc.createContainerQty(e);
	//			
	//			// data 정리 (min, max pc no )
				prdCreateManageBc.dataArrangement(e);
	//			log.debug("\n\n -------------dataArrangement 종료----------------------");
				
	//			// activity group dtl 생성
				
				prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo,prdPatternVO,account.getUsr_id() );			
				log.debug("\n\n -------------createActivityGroup 종료----------------------");
	//			
	//			// activity group dtl update
				prdCreateManageBc.updateActivityGroup(hdPctlNo);			
				log.debug("\n\n -------------createActivityGroup 종료----------------------");
							
				successCnt = updatePrdMapByPcCreate(prdSearchEurDrRePatternVO.getCopPattOrdNo(),event.getAttribute("eur_dr_seq")+"",rePctlNo, prdCreateParamVO.getBkgNo() );			
				if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());
					
					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					
					dbDao.createPrdExecEnisLog(logDesc ,"createPrdCtlgEurDoor_map", account.getUsr_id());
				}				
			}

		} catch (DAOException e4) {
			log.error("err " + e4.toString(), e4);
			throw new EventException(new ErrorHandler(e4).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * @param e
	 * @throws EventException
	 */
//	private void createContainerQty(Event e) throws EventException {
// 
//		DBRowSet dbRowset = null;
//		try {
//			//생성된 pc만큼 qty 를 만들어 준다.(mst 기준)
//			dbRowset = dbDao.selectPrdMst(e);
//			
//			
//			dbDao.createContainerQty (e);
//			
//		} catch (DAOException e1) {
//			log.error("err " + e1.toString(), e1);
//			throw new EventException(new ErrorHandler(e1).getMessage());
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//		
//	}
	
	/**
	 * @param e
	 * @throws EventException
	 */	
	public void addValCheck(Event e) throws EventException {
		EsdPrd0083Event event = (EsdPrd0083Event)e;
		PrdValChkVO prdValChkVO = event.getPrdValChkVO();
		SignOnUserAccount account = (SignOnUserAccount) event.getAttribute("account");
		int successFlag = 0;

		try {
			// val check table 의 Column 값들을insert한다
			successFlag = dbDao.addValCheck(prdValChkVO.getPcno(), prdValChkVO.getValChkcd(), prdValChkVO.getRemark(), account.getUsr_id() );
			log.debug("\n\n addValCheck successFlag: "+successFlag);
			
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
	}
	
	/**
	 * COA CM/OP Simulation 에서 사용
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@Override
	public DBRowSet createPrdCtlgFullRoutForCOA(Event e) throws EventException{

		EsdPrd0080Event event = (EsdPrd0080Event)e;

		//event.getPrdCreateParamVO().setPol("");
	

		DBRowSet rowset = null;
		try{
			// pc 생성 ---------------------------------------------------------------------------
			this.createPrdCtlgFullRout(event); 

			// TODO delete noh 2009.12.03 COA 쪽에서 처리하는 것으로 임옥영 수석님과 협의
			// cost 생성 ---------------------------------------------------------------------------
			/*
			String minPc = event.getPrdPcCreateVO().getMinPctlNo();
			String maxPc = event.getPrdPcCreateVO().getMaxPctlNo();
			String userId = ((SignOnUserAccount)event.getAttribute("account")).getUsr_id();
			int result = new CostAssignBCImpl().createCostAssignPrd(minPc, maxPc, userId);
			 */

			// master 조회 ---------------------------------------------------------------------------
			rowset = new ProductCatalogCreateDBDAO().searchProductCatalogInternalMst_1(event.getPrdPcCreateVO().getHdPctlNo());
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			String verifyMessage ="";
			if(ex.getMessage().contains( (new ErrorHandler("PRD00074")).getMessage() )){
				log.debug("\n\n pc 생성 실패 (PRD00074: Failed to create PC.)");
				event.setAttribute("prdPatternVO", event.getAttribute("prdPatternVO"));
				verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(event.getPrdCreateParamVO(), event.getPrdPcCreateVO(), (PrdPatternVO)event.getAttribute("prdPatternVO"));
			}
			throw new EventException(verifyMessage+"<||>      ",ex);
		}

		return rowset;

	}
	
	/**
	 * COA CM/OP Simulation ?먯꽌 ?ъ슜
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@Override
	public DBRowSet createPrdCtlgFullRoutForCOAMAS(Event e) throws EventException{

		EsdPrd0080Event event = (EsdPrd0080Event)e;

		//event.getPrdCreateParamVO().setPol("");
	

		DBRowSet rowset = null;
		try{
			// pc ?앹꽦 ---------------------------------------------------------------------------
			this.createPrdCtlgFullRout(event); 

			/*
			String minPc = event.getPrdPcCreateVO().getMinPctlNo();
			String maxPc = event.getPrdPcCreateVO().getMaxPctlNo();
			String userId = ((SignOnUserAccount)event.getAttribute("account")).getUsr_id();
			int result = new CostAssignBCImpl().createCostAssignPrd(minPc, maxPc, userId);
			 */

			// master 議고쉶 ---------------------------------------------------------------------------
			rowset = new ProductCatalogCreateDBDAO().searchProductCatalogInternalMst_2(event.getPrdPcCreateVO().getHdPctlNo());
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			String verifyMessage ="";
			if(ex.getMessage().contains( (new ErrorHandler("PRD00074")).getMessage() )){
				log.debug("\n\n pc ?앹꽦 ?ㅽ뙣 (PRD00074: Failed to create PC.)");
				event.setAttribute("prdPatternVO", event.getAttribute("prdPatternVO"));
				verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(event.getPrdCreateParamVO(), event.getPrdPcCreateVO(), (PrdPatternVO)event.getAttribute("prdPatternVO"));
			}
			throw new EventException(verifyMessage+"<||>      ",ex);
		}

		return rowset;

	}

	/**
	 * @param e
	 * @param dbRowsetOcn
	 * @param railCargoAvailRtnTmMap
	 * @return EventResponse
	 * @throws EventException
	 */
	@Override
	// 1.
	public EventResponse selectPrdRoutUnit(Event e, DBRowSet dbRowsetOcn, Map railCargoAvailRtnTmMap) throws EventException {
		return null;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse selectPrdRoutUnit(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		//선택화면 
		// 1.ocn route
		// 2.mt pick up yard
		// 3.full return yard
		DBRowSet dbRowsetEmpty = null;
		DBRowSet dbRowsetFullRtn = null;
		DBRowSet dbRowsetRouteInfo = null;
		DBRowSet dbRowsetPortCct = null;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PrdPcCreateVO prdPcCreateVO = (PrdPcCreateVO)event.getPrdPcCreateVO();
		PrdCreateParamVO prdCreateParamVO = (PrdCreateParamVO)event.getPrdCreateParamVO();
		try {
			// TODO delete noh
//			DBRowSet dbRowsetOcn = dbDao.selectPrdOcnRout(prdPcCreateVO.getHdPctlNo());
			List<PrdOcnRoutDoubleCallingVO> listOcn = dbDao.searchPrdCtlOcnRoutDoubleCalling(prdPcCreateVO.getHdPctlNo(),prdPcCreateVO.getSkdDate(), prdPcCreateVO.getSkdType());
//			DBRowSet dbRowsetOcn = dbDao.searchPrdCtlOcnRoutDoubleCalling(prdPcCreateVO.getHdPctlNo(),prdPcCreateVO.getSkdDate(), prdPcCreateVO.getSkdType());
			
			//화면상에 디폴트로 선택되는 pc no
			String viewPctlNo ="";
//			if(dbRowsetOcn.next()){
//				viewPctlNo = dbRowsetOcn.getString("pctl_no");
//			}
		
			log.debug("\n\n searchPrdCtlOcnRoutDoubleCalling listOcn size"+listOcn.size());
			if(listOcn.size()>0){
				PrdOcnRoutDoubleCallingVO prdOcnRoutDoubleCallingVO = (PrdOcnRoutDoubleCallingVO)listOcn.get(0);
				viewPctlNo = prdOcnRoutDoubleCallingVO .getPctlNo();
			}
			
//			String pol1Dc1Flg="N";
//			String pod1Dc1Flg="N";
//			String pol2Dc1Flg="N";
//			String pod2Dc1Flg="N";
//			String pol3Dc1Flg="N";
//			String pod3Dc1Flg="N";
//			String pol4Dc1Flg="N";
//			String pod4Dc1Flg="N";

			
			String prePol1Dc1Flg ="N";
			String postPol1Dc1Flg="N";
			String prePod1Dc1Flg ="N";
			String postPod1Dc1Flg="N";
			String prePol2Dc1Flg ="N";
			String postPol2Dc1Flg="N";
			String prePod2Dc1Flg ="N";
			String postPod2Dc1Flg="N";
			String prePol3Dc1Flg ="N";
			String postPol3Dc1Flg="N";
			String prePod3Dc1Flg ="N";
			String postPod3Dc1Flg="N";
			String prePol4Dc1Flg ="N";
			String postPol4Dc1Flg="N";
			String prePod4Dc1Flg ="N";
			String postPod4Dc1Flg="N";		
			
			for (int i = 0; i < listOcn.size(); i++) {
				PrdOcnRoutDoubleCallingVO prdOcnRoutDoubleCallingVO = (PrdOcnRoutDoubleCallingVO)listOcn.get(i);
//					if(!prdOcnRoutDoubleCallingVO.getN1stPolDcClptSeq().equals("")){
//						pol1Dc1Flg="Y";
//					} 
//					if(!prdOcnRoutDoubleCallingVO.getN1stPodDcClptSeq().equals("")){
//						pod1Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getN2ndPolDcClptSeq().equals("")){
//						pol2Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getN2ndPodDcClptSeq().equals("")){
//						pod2Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getN3rdPolDcClptSeq().equals("")){
//						pol3Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getN3rdPodDcClptSeq().equals("")){
//						pod3Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getN4thPolDcClptSeq().equals("")){
//						pol4Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getN4thPodDcClptSeq().equals("")){
//						pod4Dc1Flg="Y";
//					}
					if(!prdOcnRoutDoubleCallingVO.getPreN1stPolDc().equals("")){
						prePol1Dc1Flg="Y";
					} 
					if(!prdOcnRoutDoubleCallingVO.getPostN1stPolDc().equals("")){
						postPol1Dc1Flg="Y";
					} 
					
					if(!prdOcnRoutDoubleCallingVO.getPreN1stPodDc().equals("")){
						prePod1Dc1Flg="Y";
					}
					if(!prdOcnRoutDoubleCallingVO.getPostN1stPodDc().equals("")){
						postPod1Dc1Flg="Y";
					}
					//--------------
					if(!prdOcnRoutDoubleCallingVO.getPreN2ndPolDc().equals("")){
						prePol2Dc1Flg="Y";
					}
					if(!prdOcnRoutDoubleCallingVO.getPostN2ndPolDc().equals("")){
						postPol2Dc1Flg="Y";
					}
					if(!prdOcnRoutDoubleCallingVO.getPreN2ndPodDc().equals("")){
						prePod2Dc1Flg="Y";
					}
					if(!prdOcnRoutDoubleCallingVO.getPostN2ndPodDc().equals("")){
						postPod2Dc1Flg="Y";
					}
					//-----------------
					if(!prdOcnRoutDoubleCallingVO.getPreN3rdPolDc().equals("")){
						prePol3Dc1Flg="Y";
					}
					if(!prdOcnRoutDoubleCallingVO.getPostN3rdPolDc().equals("")){
						postPol3Dc1Flg="Y";
					}
					if(!prdOcnRoutDoubleCallingVO.getPreN3rdPodDc().equals("")){
						prePod3Dc1Flg="Y";
					}
					if(!prdOcnRoutDoubleCallingVO.getPostN3rdPodDc().equals("")){
						postPod3Dc1Flg="Y";
					}
					//------------------
					if(!prdOcnRoutDoubleCallingVO.getPreN4thPolDc().equals("")){
						prePol4Dc1Flg="Y";
					}
					if(!prdOcnRoutDoubleCallingVO.getPostN4thPolDc().equals("")){
						postPol4Dc1Flg="Y";
					}
					if(!prdOcnRoutDoubleCallingVO.getPreN4thPodDc().equals("")){
						prePod4Dc1Flg="Y";
					}
					if(!prdOcnRoutDoubleCallingVO.getPostN4thPodDc().equals("")){
						postPod4Dc1Flg="Y";
					}					
			}
			
//			if(pol1Dc1Flg.equals("Y")){
//				eventResponse.setETCData("pol1_dc_flg", "Y");
//			} else {
//				eventResponse.setETCData("pol1_dc_flg", "N");
//			}
			if(prePol1Dc1Flg.equals("Y")){
				eventResponse.setETCData("pre_pol1_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pol1_dc_flg", "N");
			}
			if(postPol1Dc1Flg.equals("Y")){
				eventResponse.setETCData("post_pol1_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pol1_dc_flg", "N");
			}
			
			if(prePod1Dc1Flg.equals("Y")){
				eventResponse.setETCData("pre_pod1_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pod1_dc_flg", "N");
			}
			if(postPod1Dc1Flg.equals("Y")){
				eventResponse.setETCData("post_pod1_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pod1_dc_flg", "N");
			}
			
			if(prePol2Dc1Flg.equals("Y")){
				eventResponse.setETCData("pre_pol2_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pol2_dc_flg", "N");
			}
			if(postPol2Dc1Flg.equals("Y")){
				eventResponse.setETCData("post_pol2_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pol2_dc_flg", "N");
			}
			
			if(prePod2Dc1Flg.equals("Y")){
				eventResponse.setETCData("pre_pod2_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pod2_dc_flg", "N");
			}
		
			if(postPod2Dc1Flg.equals("Y")){
				eventResponse.setETCData("post_pod2_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pod2_dc_flg", "N");
			}
			
			if(prePol3Dc1Flg.equals("Y")){
				eventResponse.setETCData("pre_pol3_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pol3_dc_flg", "N");
			}
			if(postPol3Dc1Flg.equals("Y")){
				eventResponse.setETCData("post_pol3_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pol3_dc_flg", "N");
			}
			
			if(prePod3Dc1Flg.equals("Y")){
				eventResponse.setETCData("pre_pod3_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pod3_dc_flg", "N");
			}
			if(postPod3Dc1Flg.equals("Y")){
				eventResponse.setETCData("post_pod3_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pod3_dc_flg", "N");
			}
			
			if(prePol4Dc1Flg.equals("Y")){
				eventResponse.setETCData("pre_pol4_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pol4_dc_flg", "N");
			}
			if(postPol4Dc1Flg.equals("Y")){
				eventResponse.setETCData("post_pol4_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pol4_dc_flg", "N");
			}
			
			if(prePod4Dc1Flg.equals("Y")){
				eventResponse.setETCData("pre_pod4_dc_flg", "Y");
			} else {
				eventResponse.setETCData("pre_pod4_dc_flg", "N");
			}
			if(postPod4Dc1Flg.equals("Y")){
				eventResponse.setETCData("post_pod4_dc_flg", "Y");
			} else {
				eventResponse.setETCData("post_pod4_dc_flg", "N");
			}
			//커서위치 원복;
//			dbRowsetOcn.beforeFirst();
			log.debug("\n view pc no:"+viewPctlNo);
			log.debug("\n prdCreateParamVO.getSumBkgQty():"+prdCreateParamVO.getSumBkgQty());

			String from = "";
			String to = "";
			if (prdCreateParamVO.getPor().substring(0, 2).equals("US") || prdCreateParamVO.getPor().substring(0, 2).equals("CA") ){
				//---free time CALL(미주일때만)--------------------------------------------------------------------------------------
				Map map = this.getRailRecevingTime(viewPctlNo, null, prdCreateParamVO.getSumBkgQty(), prdCreateParamVO.getSumCTpSz(), prdCreateParamVO.getBkgNo());

//				from = map.get("RTN_TIME") == null ? "receveTime is null" : (String)map.get("RTN_TIME");
//				to =   map.get("CUT_OFF") == null ? "receveTime is null" : (String)map.get("CUT_OFF");
				from = map.get("RTN_TIME") == null ? "" : (String)map.get("RTN_TIME");
				to =   map.get("CUT_OFF") == null ? "" : (String)map.get("CUT_OFF");
			}
			
			dbRowsetEmpty = dbDao.selectPrdEmpty(viewPctlNo, prdCreateParamVO.getMPu(), prdCreateParamVO.getMRt());
//			list1 = dbDao.searchPrdEmpty(viewPctlNo, prdCreateParamVO.getMPu(), prdCreateParamVO.getMRt());
//			eventResponse.setRs(dbRowsetOcn);
			eventResponse.setRsVoList(listOcn);
			eventResponse.setRs(dbRowsetEmpty);
			

			dbRowsetPortCct = dbDao.searchPortCct(viewPctlNo);
			String port = "";
			String cct = "";
			if(dbRowsetPortCct.next()){
				String cutOffFlag = "";
				if("Y".equals(dbRowsetPortCct.getString("rf_spcl_flg")) ){
					cutOffFlag = "RF-";
				}else if("Y".equals(dbRowsetPortCct.getString("dg_spcl_flg")) ){
					cutOffFlag = "DG-";
				}
				port = dbRowsetPortCct.getString("port");
				cct = cutOffFlag+dbRowsetPortCct.getString("cct");
				eventResponse.setETCData("port_cct_msg", "※ Port CCT ("+port+") : "+cct);
			}

			dbRowsetFullRtn = dbDao.searchFullRtnYdCct(viewPctlNo,  prdCreateParamVO.getPor(), from, to, port, cct   );
			eventResponse.setRs(dbRowsetFullRtn);

			dbRowsetRouteInfo = dbDao.searchRouteInfoByPctlNo(viewPctlNo);
			if(dbRowsetRouteInfo.next()){
				eventResponse.setETCData("arr_dt", dbRowsetRouteInfo.getString("EST_ARR_DATE"));
				eventResponse.setETCData("mt_pu_dt", dbRowsetRouteInfo.getString("MT_PU_DATE"));
				eventResponse.setETCData("transit_dt", dbRowsetRouteInfo.getString("TRANSIT_DAY"));
				eventResponse.setETCData("pc_ldd", dbRowsetRouteInfo.getString("LOAD_DT"));
				eventResponse.setETCData("cnst_flg", dbRowsetRouteInfo.getString("CNST_FLG"));
				eventResponse.setETCData("pod_cd", dbRowsetRouteInfo.getString("POD_CD"));
				eventResponse.setETCData("ttl_expn_amt", dbRowsetRouteInfo.getString("TTL_EXPN_AMT"));

				//OCN ROUTE 중 HAM / RTM 이 다 조회 된 후에 HAM 선택 할 경우 RTM 쪽의 Guide 로직 추가 20090507  <<< ENIS
				String hamRtm = "";
//				if("Y".equals(dbRowsetRouteInfo.getString("HAM_RTM"))){
//					hamRtm = "You've chosen T/S at DEHAM rather than NLRTM. \n There is a substitute Ocean Route through NLRTM and it is strongly recommended that you choose NLRTM as T/S Port to save T/S handling Cost. ";
//				}
				eventResponse.setETCData("ham_rtm", hamRtm);
			}			
			eventResponse.setETCData("sum_ctp_sz", prdCreateParamVO.getSumCTpSz() );
			eventResponse.setETCData("sum_bkg_qty", prdCreateParamVO.getSumBkgQty() );
			
			
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
		
	}


//	/**
//	 * @param prdPcCreateVO
//	 * @return
//	 * @throws EventException
//	 */
//	private String searchPrdOcnRoutDoubleCalling(PrdPcCreateVO prdPcCreateVO) throws EventException {
//		String doubleCalling = "N";
//		try{
//			List<PrdOcnRoutDoubleCallingVO> listOcn = dbDao.searchPrdCtlOcnRoutDoubleCalling(prdPcCreateVO.getHdPctlNo(),prdPcCreateVO.getSkdDate(), prdPcCreateVO.getSkdType());
////			String pol1Dc1Flg="N";
//			String prePol1Dc1Flg ="N";
//			String postPol1Dc1Flg="N";
////			String pod1Dc1Flg="N";
//			String prePod1Dc1Flg ="N";
//			String postPod1Dc1Flg="N";
////			String pol2Dc1Flg="N";
//			String prePol2Dc1Flg ="N";
//			String postPol2Dc1Flg="N";
////			String pod2Dc1Flg="N";
//			String prePod2Dc1Flg ="N";
//			String postPod2Dc1Flg="N";
////			String pol3Dc1Flg="N";
//			String prePol3Dc1Flg ="N";
//			String postPol3Dc1Flg="N";
////			String pod3Dc1Flg="N";
//			String prePod3Dc1Flg ="N";
//			String postPod3Dc1Flg="N";
////			String pol4Dc1Flg="N";
//			String prePol4Dc1Flg ="N";
//			String postPol4Dc1Flg="N";
////			String pod4Dc1Flg="N";
//			String prePod4Dc1Flg ="N";
//			String postPod4Dc1Flg="N";
//
//			for (int i = 0; i < listOcn.size(); i++) {
//				PrdOcnRoutDoubleCallingVO prdOcnRoutDoubleCallingVO = (PrdOcnRoutDoubleCallingVO)listOcn.get(i);
//					if(!prdOcnRoutDoubleCallingVO.getPreN1stPolDc().equals("")){
//						prePol1Dc1Flg="Y";
//					} 
//					if(!prdOcnRoutDoubleCallingVO.getPostN1stPolDc().equals("")){
//						postPol1Dc1Flg="Y";
//					} 
//					
//					if(!prdOcnRoutDoubleCallingVO.getPreN1stPodDc().equals("")){
//						prePod1Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getPostN1stPodDc().equals("")){
//						postPod1Dc1Flg="Y";
//					}
//					//--------------
//					if(!prdOcnRoutDoubleCallingVO.getPreN2ndPolDc().equals("")){
//						prePol2Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getPostN2ndPolDc().equals("")){
//						postPol2Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getPreN2ndPodDc().equals("")){
//						prePod2Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getPostN2ndPodDc().equals("")){
//						postPod2Dc1Flg="Y";
//					}
//					//-----------------
//					if(!prdOcnRoutDoubleCallingVO.getPreN3rdPolDc().equals("")){
//						prePol3Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getPostN3rdPolDc().equals("")){
//						postPol3Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getPreN3rdPodDc().equals("")){
//						prePod3Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getPostN3rdPodDc().equals("")){
//						postPod3Dc1Flg="Y";
//					}
//					//------------------
//					if(!prdOcnRoutDoubleCallingVO.getPreN4thPolDc().equals("")){
//						prePol4Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getPostN4thPolDc().equals("")){
//						postPol4Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getPreN4thPodDc().equals("")){
//						prePod4Dc1Flg="Y";
//					}
//					if(!prdOcnRoutDoubleCallingVO.getPostN4thPodDc().equals("")){
//						postPod4Dc1Flg="Y";
//					}
//			}
//			
//			if(prePol1Dc1Flg.equals("Y")  ||postPol1Dc1Flg.equals("Y") 
//					||prePod1Dc1Flg.equals("Y")||postPod1Dc1Flg.equals("Y")
//					||prePol2Dc1Flg.equals("Y")||postPol2Dc1Flg.equals("Y")
//					||prePod2Dc1Flg.equals("Y") ||postPod2Dc1Flg.equals("Y")
//					||prePol3Dc1Flg.equals("Y") ||postPol3Dc1Flg.equals("Y")
//					||prePod3Dc1Flg.equals("Y")||postPod3Dc1Flg.equals("Y")
//					||prePol4Dc1Flg.equals("Y")||postPol4Dc1Flg.equals("Y")
//					||prePod4Dc1Flg.equals("Y")||postPod4Dc1Flg.equals("Y")){
//				doubleCalling ="Y";
//			}
//
//		} catch (DAOException e1) {
//			log.error("err " + e1.toString(), e1);
//			throw new EventException(new ErrorHandler(e1).getMessage());
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//		return doubleCalling;
//	}

//	public DBRowSet searchPrdOcnRout(String hdPctlNo) throws EventException {
//		String  pctlNo = "";
//		DBRowSet rowsetOcn = null;
//		try{
//			rowsetOcn = dbDao.selectPrdOcnRout(hdPctlNo);
//
//		} catch (DAOException e1) {
//			log.error("err " + e1.toString(), e1);
//			throw new EventException(new ErrorHandler(e1).getMessage());
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//		return rowsetOcn;
//	}

//	/**
//	 * @param viewPctlNo
//	 * @param object
//	 * @param object2
//	 * @return
//	 */
//	private Map getCargoReturnTime(String viewPctlNo, Object object,
//			Object object2) {
//		return null;
//	}

	/**
	 * @param e
	 * @param railCargoAvailRtnTmMap
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchRouteInfoByPctlNo(Event e, Map railCargoAvailRtnTmMap) throws EventException {
		return null;
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchRouteInfoByPctlNo(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		EventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowsetEmpty = null;
		DBRowSet dbRowsetPortCct = null;
		DBRowSet dbRowsetFullRtn = null;
		DBRowSet dbRowsetRouteInfo = null;
		PrdSearchParamVO prdSearchParamVO = (PrdSearchParamVO)event.getPrdSearchParamVO();
		PrdCreateParamVO prdCreateParamVO = (PrdCreateParamVO)event.getPrdCreateParamVO();
		
		try {
			String from = "";
			String to = "";
			if (prdSearchParamVO.getPor().substring(0, 2).equals("US") || prdSearchParamVO.getPor().substring(0, 2).equals("CA") ){
			//---free time CALL(미주일때만)--------------------------------------------------------------------------------------
				Map map = this.getRailRecevingTime(prdSearchParamVO.getPctlNo(), null, prdCreateParamVO.getSumBkgQty(), prdCreateParamVO.getSumCTpSz(), prdCreateParamVO.getBkgNo());

//				from = map.get("RTN_TIME") == null ? "receveTime is null" : (String)map.get("RTN_TIME");
//				to =   map.get("CUT_OFF") == null ? "receveTime is null" : (String)map.get("CUT_OFF");
				from = map.get("RTN_TIME") == null ? "" : (String)map.get("RTN_TIME");
				to =   map.get("CUT_OFF") == null ? "" : (String)map.get("CUT_OFF");
			}
			
			dbRowsetEmpty = dbDao.selectPrdEmpty(prdSearchParamVO.getPctlNo(),prdSearchParamVO.getMPu(),"" );
			eventResponse.setRs(dbRowsetEmpty);

			dbRowsetPortCct = dbDao.searchPortCct(prdSearchParamVO.getPctlNo());
			String port = "";
			String cct = "";
			if(dbRowsetPortCct.next()){
				String cutOffFlag = "";
				if("Y".equals(dbRowsetPortCct.getString("rf_spcl_flg")) ){
					cutOffFlag = "RF-";
				}else if("Y".equals(dbRowsetPortCct.getString("dg_spcl_flg")) ){
					cutOffFlag = "DG-";
				}
				port = dbRowsetPortCct.getString("port");
				cct = cutOffFlag+dbRowsetPortCct.getString("cct");
				eventResponse.setETCData("port_cct_msg", "※ Port CCT ("+port+") : "+cct);
			}
			dbRowsetFullRtn = dbDao.searchFullRtnYdCct(prdSearchParamVO.getPctlNo(),  prdCreateParamVO.getPor(), from, to, port, cct   );
			eventResponse.setRs(dbRowsetFullRtn);

			dbRowsetRouteInfo = dbDao.searchRouteInfoByPctlNo(prdSearchParamVO.getPctlNo());
			if(dbRowsetRouteInfo.next()){
				eventResponse.setETCData("arr_dt", dbRowsetRouteInfo.getString("EST_ARR_DATE"));
				eventResponse.setETCData("mt_pu_dt", dbRowsetRouteInfo.getString("MT_PU_DATE"));
				eventResponse.setETCData("transit_dt", dbRowsetRouteInfo.getString("TRANSIT_DAY"));
				eventResponse.setETCData("pc_ldd", dbRowsetRouteInfo.getString("LOAD_DT"));
				eventResponse.setETCData("cnst_flg", dbRowsetRouteInfo.getString("CNST_FLG"));
				eventResponse.setETCData("pod_cd", dbRowsetRouteInfo.getString("POD_CD"));
				eventResponse.setETCData("ttl_expn_amt", dbRowsetRouteInfo.getString("TTL_EXPN_AMT"));

				//OCN ROUTE 중 HAM / RTM 이 다 조회 된 후에 HAM 선택 할 경우 RTM 쪽의 Guide 로직 추가 20090507  <<< ENIS
				String hamRtm = "";
//				if("Y".equals(dbRowsetRouteInfo.getString("HAM_RTM"))){
//					hamRtm = "You've chosen T/S at DEHAM rather than NLRTM. \n There is a substitute Ocean Route through NLRTM and it is strongly recommended that you choose NLRTM as T/S Port to save T/S handling Cost. ";
//				}
				eventResponse.setETCData("ham_rtm", hamRtm);
			}
			
			String returnStr = selectReturnStrToBkg(prdSearchParamVO.getPctlNo());
			eventResponse.setETCData("returnStr", returnStr);
			
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	@Override
	public EventResponse searchPrdCtlgFullRout(Event e) throws EventException {
		EsdPrd0081Event event = (EsdPrd0081Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowsetRouteInfo = null;
//		List<SearchPrdFullRouteVO> list = null;
		PrdSearchParamVO prdSearchParamVO = (PrdSearchParamVO)event.getPrdSearchParamVO();
		try {
			dbRowsetRouteInfo = dbDao.searchPrdCtlgFullRout(prdSearchParamVO.getPctlNo());
//			list = (List<SearchPrdFullRouteVO>) dbDao.searchPrdCtlgFullRoutByPctlNo(prdSearchParamVO.getPctlNo());
//			eventResponse.setRsVoList(list);
			eventResponse.setRs(dbRowsetRouteInfo);
			
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param pctlNo
	 * @param bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchPrdConstraint(String pctlNo, String bkgNo) throws EventException {
		boolean isConstraint = false;
		String rtnStr = "N";
		try {
			List<PrdConstraintInfoVO> list = dbDao.searchPrdCnstInfoNode(pctlNo);
			if (list != null && list.size() > 0) {
				isConstraint = true;
			}
			if (!isConstraint) {
				list = dbDao.searchPrdCnstInfoLink(pctlNo);
				if (list != null && list.size() > 0) {
					isConstraint = true;
				}
			}
			if (!isConstraint) {
				list = dbDao.searchPrdCnstInfoRoute(pctlNo);
				if (list != null && list.size() > 0) {
					isConstraint = true;
				}
			}
			if (!isConstraint) {
				PrdSearchParamVO prdSearchParamVO = new PrdSearchParamVO();
//				String bkgNo = "";
				prdSearchParamVO.setBkgNo(bkgNo );
				prdSearchParamVO.setPctlNo(pctlNo);
				list = dbDao.searchPrdCnstInfoIrgPolPod(prdSearchParamVO);
//				list = dbDao.searchPrdCnstInfoIrgPolPod(pctlNo);
				if (list != null && list.size() > 0) {
					isConstraint = true;
				}
			}
			
			if (isConstraint) {
				rtnStr = "Y";
			}
			
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
		return rtnStr;
	}

	/**
	 * @param pctlNo
	 * @param bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchPrdImDgConstraint(String pctlNo, String bkgNo) throws EventException {
//		boolean isConstraint = false;
		String rtnStr="Y";
		try {
			List<PrdConstraintInfoVO> list = null;
			 

			PrdSearchParamVO prdSearchParamVO = new PrdSearchParamVO();
			prdSearchParamVO.setBkgNo(bkgNo );
			prdSearchParamVO.setPctlNo(pctlNo);
			list = dbDao.searchPrdCnstInfoIrgPolPod(prdSearchParamVO);
			if (list != null && list.size() > 0) {
				for(int i=0; i<list.size(); i++){
					PrdConstraintInfoVO vo = (PrdConstraintInfoVO)list.get(0);
					if(vo.getSvcUseFlg().equals("N") && vo.getPctlImdgClssCtnt().length()> 0 ) {
						throw new EventException(new ErrorHandler("PRD99998", new String[]{vo.getNtwkUtNm()+"\nConstraint - DG cargo with following IMDG class is unavailable for subj. inland route "+"\n"+vo.getPctlImdgClssCtnt()}).getMessage());
					}
				}
			}
			
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
		return rtnStr;
	}
	/**
	 * @param Event e
	 * @return List<PrdPatternVO>
	 * @throws EventException
	 */
	@Override
	public List<PrdPatternVO> getReplanePatternForMultiPrd(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		List<PrdBkgCopMapVO> insertVoList = new ArrayList<PrdBkgCopMapVO>();
 		String mapSeq ="";
 		List<PrdPatternVO> list = null;
		try{
			// map table의 CRNT_FLGfmf 'N'으로 update한다. 
			dbDao.updatePrdMapInit(prdCreateParamVO.getBkgNo(), "");

			// PRD_BKG_COP_MAP_SEQ sequence를 얻는다.
			mapSeq = dbDao.getPrdBkgCopMapSeq();
			
			//prd map 생성 
			//CHM-201005548-01:[SCEM / PRD] F.H. 기능 연계한 개발요청
			insertVoList = dbDao.getReplanePattern(prdCreateParamVO.getBkgRcvT(), prdCreateParamVO.getBkgDelT(),
					prdCreateParamVO.getRcvT(), prdCreateParamVO.getDelT(), prdCreateParamVO.getBkgNo(), mapSeq, "P" ,prdCreateParamVO.getFlexHgtFlg() ,prdCreateParamVO.getCntrTpszQtyStr(), prdCreateParamVO.getBkgOfc() );
			log.debug("getReplanePattern ====OK" );
            dbDao.addReplanPatterns(insertVoList);

			// COP_PATT_ORD_NO 의  데이터를 GROUP BY 로 가져온다.
			// COP_PATT_ORD_NO 의 데이터만큼 PC를 생성
			list  = dbDao.searchCurrentPatternOrd(mapSeq);
			log.debug("\n\n searchCurrentPatternOrd(COP_PATT_ORD_NO 의  데이터를 GROUP BY 로 가져온다 ) list size:"+list.size());
			
		}catch(DAOException ex){
			//이전 소스수정본으로 다시 돌려본다.(위 로직 안정화되면 삭제)---------------------------
			try {
				dbDao.updatePrdMapInit(prdCreateParamVO.getBkgNo(), "");
				mapSeq = dbDao.getPrdBkgCopMapSeq();
				insertVoList = dbDao.getReplanePatternOld(prdCreateParamVO.getBkgRcvT(), prdCreateParamVO.getBkgDelT(),
						prdCreateParamVO.getRcvT(), prdCreateParamVO.getDelT(), prdCreateParamVO.getBkgNo(), mapSeq, "P" ,prdCreateParamVO.getFlexHgtFlg() ,prdCreateParamVO.getCntrTpszQtyStr(), prdCreateParamVO.getBkgOfc() );
	            dbDao.addReplanPatterns(insertVoList);
	            list  = dbDao.searchCurrentPatternOrd(mapSeq);
	            
	            if((dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					map.put("mapSeq", mapSeq);
					map.put("PrdCreateParamVO", prdCreateParamVO);
					
					String logDesc = "prd_map " + this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					
					dbDao.createPrdExecEnisLog(logDesc ,"getReplanePatternForMultiPrd", "system");
				}
	            
	            return list;
			} catch (Exception e2) {
				throw new EventException(e2.getMessage(), e2);
			}
			//--------------------------------------------------------------------------
			//throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * @param mapSeq
	 * @return List<PrdPatternVO>
	 * @throws EventException
	 */	
	private List<PrdPatternVO> getReplanePatternByMapSeq(String mapSeq) throws EventException {
		List<PrdPatternVO> list  = null;
		try {
			list  = dbDao.searchCurrentPatternOrd(mapSeq);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * @param mapSeq
	 * @param bkgNo
	 * @param mainPatternPctlNo
	 * @param copPattOrdNo
	 * @return int
	 * @throws EventException
	 */	
	@Override
	public int updatePrdMapByPcNo(String mapSeq, String bkgNo, String mainPatternPctlNo,
			String copPattOrdNo) throws EventException {
		int ret = 0;
		try {
			ret = dbDao.updatePrdMapByPcNo( mapSeq,  bkgNo, mainPatternPctlNo,copPattOrdNo);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}

		return ret;
	}
	
	/**
	 * @param e
	 * @throws EventException
	 */	
	public void createSubPatternPrdCtlgFullRout(Event e) throws EventException {
			EsdPrd0080Event event = (EsdPrd0080Event)e;
			PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
			SignOnUserAccount account = (SignOnUserAccount)e.getAttribute("account"); 
			PrdPatternVO prdPatternVO = null;
			if(prdPatternVO == null ){
				log.debug("\n\n ------------prdPatternVO == null ----------\n\n");
			}
			// pc no 생성 
			PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
			String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen( prdCreateParamVO.getPcMode());
			
			// pc return value object create
			PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
			// pc_no_head set		
			prdPcCreateVo.setHdPctlNo(hdPctlNo);
			// Merchant Haulage 처리를 위해 bkg_no 추가
			prdPcCreateVo.setBkgNo(prdCreateParamVO.getBkgNo());
			prdPcCreateVo.setIdaHlgTpCd(prdCreateParamVO.getIdaHlgTpCd());
			
			//skdType(L,V) 찾음.
			String skdType = prdCreateManageBc.getSkdType( prdCreateParamVO.getTVvd(),prdCreateParamVO.getLdDt(), prdCreateParamVO.getPol1());
			
			//skdType(L,V) 셋팅, skdDate 셋팅.
			prdPcCreateVo.setSkdType(skdType);
			
			//skdDate 셋팅. (date, vvd)
			if(skdType.equals("L")){
				prdPcCreateVo.setSkdDate(prdCreateParamVO.getLdDt());
			}else {
				prdPcCreateVo.setSkdDate(prdCreateParamVO.getTVvd());
			}
			
			event.setPrdPcCreateVO(prdPcCreateVo);
			
//			try {
//				// prd mst,dtl 생성

				List list = (List)event.getAttribute("PATTERN_LIST");
				
				for(int i=0; i<list.size(); i++){
					int successCnt = 0;
					try {
						//ord= 1이 아닌 부패턴으로 pc를 생성한다.
						//리플랜시 선택버튼을 클릭할때는 주패턴이 빠진 list를 가지고 처리함.
						//pc가 1개이상 생길수 있으므로 뒷단에서 주패턴 PC의 ocn route를 가진 pc를 찾아 pc no로 업데이트한다.
						prdPatternVO = (PrdPatternVO)list.get(0);
						successCnt = dbDao.createProductCatalogIncludeReplane(prdCreateParamVO, prdPcCreateVo, prdPatternVO, account.getUsr_id() );
						if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
							log.debug("\n\n PRD log On:");
							Map map = new HashMap();
							
							map.put("PrdPatternVO", prdPatternVO);
							map.put("PrdCreateParamVO", prdCreateParamVO);
							map.put("hdPctlNo", hdPctlNo);
							map.put("usrId", account.getUsr_id());
							
							String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
							log.debug("\n\n log::::"+logDesc );
							
							dbDao.createPrdExecEnisLog(logDesc ,"createSubPatternPrdCtlgFullRout", account.getUsr_id());
						}					
					} catch (Exception ex1) {
						log.error("err " + ex1.toString(), ex1);
						throw new EventException(new ErrorHandler(ex1).getMessage());
					}
					if(successCnt <= 0 ){
						try {
							//pc가 생성되지 않았으면 map 에 'F'로 업데이트
							dbDao.updatePrdMapByPcCreateFail(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq() );
						} catch (Exception ex2) {
							log.error("err " + ex2.toString(), ex2);
							throw new EventException(new ErrorHandler(ex2).getMessage());
						}
					
					} else { // pc가 정상 생성되었을때 처리 
						
						//부패턴의 pc는 실패해도 무시되게 try 로 잡아 처리한다.
						try {
	//						// qty 생성
							prdCreateManageBc.createContainerQty(e);
	//						
	//						// data 정리 (min, max pc no )
							prdCreateManageBc.dataArrangement(e);
	//						
							log.debug("\n\n -------------dataArrangement 종료----------------------");
							
	//						// activity group dtl 생성
							prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo,prdPatternVO,account.getUsr_id() );
							
							
							log.debug("\n\n -------------createActivityGroup 종료----------------------");
	//						
	//						// activity group dtl update
							prdCreateManageBc.updateActivityGroup(hdPctlNo);
							
							log.debug("\n\n -------------createActivityGroup 종료----------------------");
							
							//pc가 1개이상 생길수 있으므로 뒷단에서 주패턴 PC의 ocn route를 가진 pc를 찾아 pc no로 업데이트한다.
							log.debug("\n\n pc가 1개이상 생길수 있으므로 뒷단에서 주패턴 PC의 ocn route를 가진 pc를 찾아 pc no로 업데이트한다.");
							log.debug("\n\n 부패턴의prdPatternVO.getCopPattOrdNo() :"+prdPatternVO.getCopPattOrdNo() );
							
							/*
							 * prdPatternVO: 부패턴 정보
							 * hdPctlNo : 부패턴으로 생성된 pc
							 */
							successCnt = dbDao.updatePrdBkgCopMapBySubPatternOrdNo(prdPatternVO, hdPctlNo);
							int successFailCnt = 0;
							if(successCnt ==0 ){
								successFailCnt =dbDao.updatePrdMapByPcCreateFail(prdPatternVO.getCopPattOrdNo(), prdPatternVO.getCopMapgSeq() );
							}
							if(( dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
								log.debug("\n\n PRD log On:");
								Map map = new HashMap();
								
								map.put("PrdPatternVO", prdPatternVO);
								map.put("MapgSeq", prdPatternVO.getCopMapgSeq());
								map.put("hdPctlNo", hdPctlNo);
								map.put("usrId", account.getUsr_id());
								
								String logDesc = "successCnt " + Integer.toString(successCnt)+"successFailCnt " + Integer.toString(successFailCnt)  + " " + this.getParamString(map);
								log.debug("\n\n log::::"+logDesc );
								
								dbDao.createPrdExecEnisLog(logDesc ,"createSubPattern Map", account.getUsr_id());
							}	
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							try {
								if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
									log.debug("\n\n PRD log On:");
									Map map = new HashMap();
									
									map.put("PrdPatternVO", prdPatternVO);
									map.put("PrdCreateParamVO", prdCreateParamVO);
									map.put("hdPctlNo", hdPctlNo);
									map.put("usrId", account.getUsr_id());
									
									String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
									log.debug("\n\n log::::"+logDesc );
									
									dbDao.createPrdExecEnisLog(logDesc ,"createSubPattern Exec", account.getUsr_id());
								}							
								
							} catch (Exception ex3) {
								log.error("err " + ex3.toString(), ex3);
								throw new EventException(new ErrorHandler(ex3).getMessage());
							}
							log.error("err " + e1.toString(), e1);
							throw new EventException(new ErrorHandler(e1).getMessage());

						}	
						
					}
					
				}

//			} catch (Exception ex) {
//				log.error("err " + ex.toString(), ex);
//				throw new EventException(new ErrorHandler(ex).getMessage());
//			}
	}

	/**
	 * @param e
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet createProductCatalogInquiry(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		
		// TODO delete noh
		//event.getPrdCreateParamVO().setPol("");
		//event.getPrdCreateParamVO().setObTrspMode("TD");
		//event.getPrdCreateParamVO().setIbTrspMode("TR");

//		event.getPrdCreateParamVO().setInternalSkdType("L");

		DBRowSet rowset = null;
		try{
			// pc 생성 ---------------------------------------------------------------------------
//			this.createPrdCtlgFullRout(event);

			// cost 생성 ---------------------------------------------------------------------------
//			String minPc = event.getPrdPcCreateVO().getMinPctlNo();
//			String maxPc = event.getPrdPcCreateVO().getMaxPctlNo();
//			String userId = ((SignOnUserAccount)event.getAttribute("account")).getUsr_id();
//			int result = new CostAssignBCImpl().createCostAssignPrd(minPc, maxPc, userId);

			// master 조회 ---------------------------------------------------------------------------
			rowset = new ProductCatalogCreateDBDAO().searchProductCatalogInternalMst_1(event.getPrdPcCreateVO().getHdPctlNo());
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return rowset;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
//	public DBRowSet createProductCatalogforPreCm(Event e) throws EventException {
//		EsdPrd0080Event event = (EsdPrd0080Event)e;
//		DBRowSet rowset = null;
//		String prdCtlNo = ""; 
//		String pol = event.getPrdCreateParamVO().getPol();
//		String pod = event.getPrdCreateParamVO().getPod();
//		String del = event.getPrdCreateParamVO().getDel();
//		prdCtlNo = "X" + pol + del ; 
//		try{
//			// master 조회 ---------------------------------------------------------------------------
//			rowset = new ProductCatalogCreateDBDAO().searchProductCatalogInternalMst_cm(prdCtlNo, pod);
//		}catch(DAOException ex){
//			throw new EventException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			throw new EventException(ex.getMessage(), ex);
//		}
//		
//		return rowset;
//	}	

	/**
	 * @param e
	 * @return List
	 * @throws EventException
	 */	
	public List searchProductCatalogInquiryDetail(Event e) throws EventException {
		List list = null;
		try{
			list = new ProductCatalogCreateDBDAO().searchProductCatalogInternalDetail((String) e.getAttribute("search_pctl_no"));
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return list;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
//	public List searchProductCatalogforPreCmDetail(Event e) throws EventException {
//		EsdPrd0080Event event = (EsdPrd0080Event)e;
//		List list = null;
//		try{
//			String pctl_no = (String) e.getAttribute("search_pctl_no");
//			// qty 생성 ---------------------------------------------------------------------------
//			updateContainerQtyforPreCm(event);
//			// cost 생성 ---------------------------------------------------------------------------
//			String minPc = pctl_no;
//			String maxPc = pctl_no;
//			String userId = ((SignOnUserAccount)event.getAttribute("account")).getUsr_id();
//			int result = new CostAssignBCImpl().createCostAssignPrd(minPc, maxPc, userId);
//			// detail 조회 ---------------------------------------------------------------------------
//			list = new ProductCatalogCreateDBDAO().searchProductCatalogInternalDetail(pctl_no);
//		}catch(DAOException ex){
//			throw new EventException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			throw new EventException(ex.getMessage(), ex);
//		}
//		
//		return list;
//	}	
	
	/**
	 * 선택화면에서 Empty Pick Up Date 변경
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEqInventory(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		//선택화면 
		// 2.mt pick up yard
		DBRowSet dbRowsetEmpty = null;
		
		EventResponse eventResponse = new GeneralEventResponse();
		
		PrdSearchParamVO prdSearchParamVO = (PrdSearchParamVO)event.getPrdSearchParamVO();
		try {
			log.debug("\n\n----------prdSearchParamVO.getMPuDt():"+prdSearchParamVO.getMPuDt());
			dbRowsetEmpty = dbDao.selectPrdEmpty(prdSearchParamVO.getPctlNo(),prdSearchParamVO.getMPu(), prdSearchParamVO.getMPuDt() );
			
			eventResponse.setRs(dbRowsetEmpty);
			
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 선택화면에서 Constraint Remarking
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCnstRemark(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		//선택화면 
		// ESD_PRD_0020 PC Inquiry 화면
		DBRowSet dbRowsetCnstRmk = null;
		EventResponse eventResponse = new GeneralEventResponse();
		PrdCnstRemarkVO prdCnstRemarkVO = (PrdCnstRemarkVO)event.getPrdCnstRemarkVO();
		try {
			
			dbRowsetCnstRmk=dbDao.searchCnstRemark(prdCnstRemarkVO );

			String cnst_rmk = "Your booking is under Network Constraint in PRD. \n";
			StringBuffer sbCnstRmk = new StringBuffer();
			while(dbRowsetCnstRmk.next()){
//				cnst_rmk =  cnst_rmk + dbRowsetCnstRmk.getString("CNST_RMK") + "\n";
				sbCnstRmk.append(dbRowsetCnstRmk.getString("CNST_RMK")).append("\n");
			}
			cnst_rmk = sbCnstRmk.toString();
			eventResponse.setETCData("cnst_rmk", cnst_rmk);		
			
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * TRO 처리.
	 * ★2009-10-21 KIM KWIJIN
	 * 
	 * @param e
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createIrgSoReplane(Event e,String creUsrId) throws EventException{
		EsdPrd0080Event event = (EsdPrd0080Event)e;
//		EventResponse eventResponse = new GeneralEventResponse();
		String retPctlNo="";
		try{
			
			// pc no 생성 
			PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
			PrdCreateParamVO  prdCreateParamVO = event.getPrdCreateParamVO();
			PrdPatternVO prdPatternVO = new PrdPatternVO();
			
			String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(prdCreateParamVO.getPcMode());
			
			
//			DBRowSet getParams = null;
//			DBRowSet subRoutParam = null;
//			String cntrNo = JSPUtil.getNull(event.getPrdCreateParamVO().getCntrNo());
 
			
			// pc return value object create
			PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
			// pc_no_head set		
			prdPcCreateVo.setHdPctlNo(hdPctlNo);
			
			event.setPrdPcCreateVO(prdPcCreateVo);

			String troSeq = prdCreateParamVO.getTroSeq();
			String troSubSeq = prdCreateParamVO.getTroSubSeq();
			
			String copNo = "";
			String pcMode = "";
			String doorZn = "";
			String fullRtnCy = "";
			String fullPuCy = "";
			String mtPu = "";
			String mtRtn = "";
			String area_conti_cd = prdCreateParamVO.getAreaContiCd();//구주인지 아닌지 판단(X,E)값이 들어온다
			String ioBndCd = prdCreateParamVO.getReplaneBndCd();
			
			// 해당 TRO 가 이미 매핑되어 있는지 체크
			// 매핑되어 있으면 COP_NO가 안나옴.
			int cnt = dbDaoTro.checkSceTroMapping(ioBndCd, area_conti_cd, prdCreateParamVO.getBkgNo(), troSeq, troSubSeq );
			if(cnt>0){
//				throw new EventException("already tro created!");
				
				throw new EventException(new ErrorHandler("PRD00060").getMessage());
				
			}
//			:IO_BND_CD
//			:AREA_CONTI_CD
//			:BKG_NO
//			:TRO_SEQ
//			:TRO_SUB_SEQ
			BkgCopManageBC bkgCopManageBC = new BkgCopManageBCImpl();
			SearchCopVO copVO = bkgCopManageBC.searchCopNoFrmPrdByTro(prdCreateParamVO.getBkgNo(), troSeq, troSubSeq, ioBndCd, area_conti_cd);
			//cop_no 
			copNo = copVO.getCopNo();
			// Merchant Haulage 처리를 위해 cop_no 추가
			prdPcCreateVo.setCopNo(copNo);
			prdPcCreateVo.setIdaHlgTpCd(prdCreateParamVO.getIdaHlgTpCd());
			if ("O".equals(ioBndCd)) {
				mtPu = copVO.getMtyPkupYdCd();
			}
			log.debug("\n\n ----------------------" +
					"\n pc_mode prdCreateParamVO.getPcMode() :"+prdCreateParamVO.getPcMode()+
					"\n copNo:"+copNo);			

//CHM-201005548에의해 진석호요청  - SCE 김인수 수석의견에 의해 삭제시작 (20101130)
//			if (copNo==null || copNo.equals("") ) {
//				if(( dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
//					log.debug("\n\n PRD log On:");
//					Map map = new HashMap();
//					
//					map.put("PrdCreateParamVO", prdCreateParamVO);
//					map.put("hdPctlNo", hdPctlNo);
//					
//					map.put("ioBndCd",          ioBndCd        );      
//					map.put("troSeq",           troSeq        );      
//					map.put("troSubSeq",        troSubSeq        );      
//					map.put("area_conti_cd",    area_conti_cd );      
// 
//					map.put("creUsrId",         creUsrId       );
//					map.put("hdPctlNo",         hdPctlNo       );
// 
//					
//					String logDesc =   this.getParamString(map);
//					log.debug("\n\n log::::"+logDesc );
//				
//					
////					dbDao.createPrdExecEnisLog(log_desc,app_info);
//					dbDao.createPrdExecEnisLog(logDesc ,"searchCopNoFrmPrdByTro", creUsrId);
//				}				
//				throw new EventException(new ErrorHandler("PRD00076").getMessage());
//			}
//CHM-201005548에의해 진석호요청  - SCE 김인수 수석의견에 의해 삭제시작 (20101130)

			pcMode = prdCreateParamVO.getPcMode();
			log.debug("\n\n ----------------------" +
					"\n pc_mode prdCreateParamVO.getPcMode() :"+prdCreateParamVO.getPcMode()+
					"\n pc_mode:"+pcMode);	
			doorZn = prdCreateParamVO.getDorZone();
			// o/b 의 full return yard
			fullRtnCy = prdCreateParamVO.getTroRtnCy();
			// i/b 의 full pick up yard
			fullPuCy = prdCreateParamVO.getTroPkupCy();
			// o/b의 m'ty pick up cy
			if (prdCreateParamVO.getMPu() != null && !"".equals(prdCreateParamVO.getMPu())) {
				mtPu = prdCreateParamVO.getMPu();
			}
//			if (prdCreateParamVO.getTroPkupCy() != null && !prdCreateParamVO.getTroPkupCy().trim().equals("")) { // pickup cy의 경우 동적 처리를 요구하지 않아 일단 현상태로 둔다.
//				mtPu = prdCreateParamVO.getTroPkupCy();                                                          // inbound와 pair가 되기 위해서는 해당 주석을 풀고 처리해야한다.
//			} else {
//				mtPu = prdCreateParamVO.getMPu();
//			}
			// i/b의 m'ty return cy
//			mtRtn = prdCreateParamVO.getMRt();
			if (prdCreateParamVO.getTroRtnCy() != null && !prdCreateParamVO.getTroRtnCy().trim().equals("")) {
				mtRtn = prdCreateParamVO.getTroRtnCy();
			} else {
				mtRtn = prdCreateParamVO.getMRt();
			}
			
			
			List<PrdSceGetParamVO> sceGetParamList = null;
			sceGetParamList = dbDaoSce.sceGetParam(copNo, ioBndCd, pcMode, doorZn, fullRtnCy, fullPuCy, mtPu, mtRtn );

			//cntrNo 가 
//			if(!cntrNo.equals("")){
//				getParams = dbDaoTro.troGetParam(copNo, event.getPrdCreateParamVO().getReplaneBndCd());
//				
//			}else{
//				getParams = dbDaoTro.troGetParamNotCntrNo(event.getPrdCreateParamVO().getPcMode() ,event.getPrdCreateParamVO().getBkgNo(), event.getPrdCreateParamVO().getReplaneBndCd());
//			}
			
//			subRoutParam = dbDaoTro.troInlandSubRout(copNo, event.getPrdCreateParamVO().getReplaneBndCd());

			
			String srTerm = "";
			String sdTerm = "";
			String cct = "";
			String pmF = "";
			String podT = "";
			String polT = "";
			String spmFlg = "";
			String srfCntr = prdCreateParamVO.getRfF();
			String smtPu = "";
			String smtRtn = "";
			String inlndRoutOrg = "";
			String inlndRoutDest = "";
			String sinclShtlSoFlg =  "";
			String subRout = "";
			String fullCy = "";
			String trspModCd = prdCreateParamVO.getTrMode();
			String stermNode = "";
			String prdCtlNo = "";
			String outStr   =     "";
			String inStr    =     "";
			String ocnStr   =     "";
			String obTroFlg =     "";
			String ibTroFlg =     "";
			String porNodCd =     "";
			String polNodCd =     "";
			String delNodCd =     "";
			String fullRtnYdCd =  "";
			String fullPkUpYdCd = "";
			String obTrspMode =   "";
			String ibTrspMode =   "";
			
			PrdSceGetParamVO prdSceGetParamVO = null;
			
			if(sceGetParamList != null && sceGetParamList.size()>0) {
				prdSceGetParamVO = (PrdSceGetParamVO)sceGetParamList.get(0);
				srTerm = JSPUtil.getNull(prdSceGetParamVO.getRcvTermCd());
				sdTerm = JSPUtil.getNull(prdSceGetParamVO.getDeTermCd());
				cct    = JSPUtil.getNull(prdSceGetParamVO.getCct());
				podT   = JSPUtil.getNull(prdSceGetParamVO.getPodT());
				polT   = JSPUtil.getNull(prdSceGetParamVO.getPolT());
				smtPu  = JSPUtil.getNull(prdSceGetParamVO.getMtPu());
				smtRtn = JSPUtil.getNull(prdSceGetParamVO.getMtRtn());
				inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getRoutOrgNodCd());
				inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getRoutDestNodCd());
				// I/O Bound에 따라 Included Shuttle S/O Flag 구분  - #Mod - 2010.05.27 by sj
				sinclShtlSoFlg = JSPUtil.getNull(prdSceGetParamVO.getIoBndCd()).equals("I")?JSPUtil.getNull(prdSceGetParamVO.getIbInclShtlSoFlg()):JSPUtil.getNull(prdSceGetParamVO.getObInclShtlSoFlg());
				prdCtlNo = JSPUtil.getNull(prdSceGetParamVO.getPctlNo());
				//COP_SEARCH_SAME_ROUTE.txt 를 실행해서 PCTL_NO가 있으면 리턴하고 끝.-----------------------------------------
				outStr   = JSPUtil.getNull(prdSceGetParamVO.getOutBound());
				inStr    = JSPUtil.getNull(prdSceGetParamVO.getInBound());				
				ocnStr   = JSPUtil.getNull(prdSceGetParamVO.getOcnBound());
				
				if(ioBndCd.equals("O")) {
					subRout = outStr ;
					log.debug("\n o/b inlndRoutOrg before: "+inlndRoutOrg);
					inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd()).equals("")? inlndRoutOrg :prdSceGetParamVO.getPorNodCd() ;
					log.debug("\n o/b inlndRoutOrg after: "+inlndRoutOrg);
				}else if (ioBndCd.equals("I")) {
					subRout = inStr ;
					//door so가 있을경우 
					log.debug("\n i/b inlndRoutDest before: "+inlndRoutDest);
					inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getDelNodCd()).equals("")? inlndRoutDest: prdSceGetParamVO.getDelNodCd() ;
					log.debug("\n i/b inlndRoutDest after: "+inlndRoutDest);
				}else if (ioBndCd.equals("T")){
					subRout = ocnStr ;
				}
				obTroFlg = JSPUtil.getNull(prdSceGetParamVO.getObTroFlg());
				ibTroFlg = JSPUtil.getNull(prdSceGetParamVO.getIbTroFlg());
				porNodCd = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd());
				polNodCd = JSPUtil.getNull(prdSceGetParamVO.getPolYdCd());
				delNodCd = JSPUtil.getNull(prdSceGetParamVO.getPolYdCd());
				fullRtnYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullRtnYdCd());
				fullPkUpYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullPkupYdCd());
				
				if(pcMode.equals("O")) {
					obTrspMode = JSPUtil.getNull(prdCreateParamVO.getObTrspMode()) ;
				}else {
					obTrspMode = JSPUtil.getNull(prdSceGetParamVO.getObTrspMode());
				} 
				
				if(pcMode.equals("I")) {
					ibTrspMode = JSPUtil.getNull(prdCreateParamVO.getIbTrspMode()) ;
				}else {
					ibTrspMode = JSPUtil.getNull(prdSceGetParamVO.getIbTrspMode());
				}			
			}
				
//			if(subRoutParam !=null && subRoutParam.next()){
//				subRout = JSPUtil.getNull(subRoutParam.getString("TS_STRING"));
//			}
			
			// tro o/b FULL_rtn_cy or i/b FULL_pick_up_cy 
			if(JSPUtil.getNull(prdCreateParamVO.getPcMode()).equals(PrdConstants.PRD_PC_MOD_I)){
				fullCy = JSPUtil.getNull(prdCreateParamVO.getTroPkupCy());
				ibTrspMode = prdCreateParamVO.getTrMode();
			}else if(JSPUtil.getNull(prdCreateParamVO.getPcMode()).equals(PrdConstants.PRD_PC_MOD_O)){
				fullCy = JSPUtil.getNull(prdCreateParamVO.getTroRtnCy());
				obTrspMode = prdCreateParamVO.getTrMode();
			}
			


//			retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(),outStr, inStr, ocnStr, smtPu ,
//					smtRtn, obTroFlg, ibTroFlg, porNodCd, polNodCd, srTerm, sdTerm, 
//					delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode );
			if(ioBndCd.equals("O")) {
				retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(),outStr, inStr, ocnStr, smtPu ,
						smtRtn, obTroFlg, ibTroFlg, inlndRoutOrg, polNodCd, srTerm, sdTerm, 
						delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode );
			}else if (ioBndCd.equals("I")) {
				retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(),outStr, inStr, ocnStr, smtPu ,
						smtRtn, obTroFlg, ibTroFlg, porNodCd, polNodCd, srTerm, sdTerm, 
						inlndRoutDest, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode );
			}
			
			if(retPctlNo.equals("")){
				// PRD MST,DTL 생성
				// cop_auto_change.txt 사용 
//				dbDaoTro.troAutoChange(ioBndCd, srTerm, sdTerm, creUsrId, newPrdCtlNo, cct, pmF, podT, polT, spmFlg, srfCntr, smtPu, smtRtn, inlndRoutOrg, inlndRoutDest, sinclShtlSoFlg, subRout, fullCy, trspModCd, stermNode, prdCtlNo);
				//sceSoReplan 의 pc생성 sql 을 사용
 				//PrdSceGetParamVO prdSceGetParamVO = null;
				if(sceGetParamList != null && sceGetParamList.size()>0) {
					prdSceGetParamVO = (PrdSceGetParamVO)sceGetParamList.get(0);
					int successCnt = 0;
					if(!prdSceGetParamVO.getNewPol().equals("") || !prdSceGetParamVO.getNewPod().equals("")){
						// COP_AUTO_CHANGE_OCN_INLAND_CHANGE.txt 실행.  
						// prd mst, dtl 생성 
						successCnt =dbDaoSce.createSceSoReplaneOcnInlndChange(prdSceGetParamVO,hdPctlNo);
 
					} else {
						//변경되는 바운드부분만 새로 만들고 나머지는 기존거를 사용함 
						if(pcMode.equals("O")) {
							trspModCd = obTrspMode;
						}else if(pcMode.equals("I")) {
							trspModCd = ibTrspMode;
						}
						successCnt =dbDaoTro.troAutoChange(ioBndCd, srTerm, sdTerm, creUsrId, hdPctlNo, cct, pmF, podT, polT, spmFlg, srfCntr, smtPu, smtRtn, inlndRoutOrg, inlndRoutDest, sinclShtlSoFlg, subRout, fullCy, trspModCd, stermNode, prdCtlNo);
 
					}
					
//					// Auto IRG를 생성해야하는지 검사하고, 필요시 생성한다. 20100713
//					prdCreateManageBc.createAutoIRG(hdPctlNo, creUsrId, ""); // 기본값 정의되어있어 상관없이 처리가능
					
					if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
						log.debug("\n\n PRD log On:");
						Map map = new HashMap();
						
						map.put("prdSceGetParamVO", prdSceGetParamVO);
						map.put("PrdCreateParamVO", prdCreateParamVO);
						map.put("hdPctlNo", hdPctlNo);
						
						map.put("ioBndCd",          ioBndCd        );      
						map.put("srTerm",           srTerm         );
						map.put("sdTerm",           sdTerm         );
						map.put("creUsrId",         creUsrId       );
						map.put("cct",              cct            );
						map.put("pmF",              pmF            );
						map.put("podT",             podT           );
						map.put("polT",             polT           );
						map.put("spmFlg",           spmFlg         );
						map.put("srfCntr",          srfCntr        );
						map.put("smtPu",            smtPu          );
						map.put("smtRtn",           smtRtn         );
						map.put("inlndRoutOrg",     inlndRoutOrg   );
						map.put("inlndRoutDest",    inlndRoutDest  );
						map.put("sinclShtlSoFlg",   sinclShtlSoFlg );
						// I/O Included Shuttle S/O Flag - #Add 2010.05.27 by sj
						map.put("ibInclShtlSoFlg",  prdSceGetParamVO.getIbInclShtlSoFlg() );
						map.put("obInclShtlSoFlg",  prdSceGetParamVO.getObInclShtlSoFlg() );
						map.put("subRout",          subRout        );
						map.put("fullCy",           fullCy         );
						map.put("trspModCd",        trspModCd      );
						map.put("stermNode",        stermNode      );
						map.put("prdCtlNo",         prdCtlNo       );
						
						String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
						log.debug("\n\n log::::"+logDesc );
					
						
//						dbDao.createPrdExecEnisLog(log_desc,app_info);
						dbDao.createPrdExecEnisLog(logDesc ,"createIrgSoReplane", creUsrId);
					}
				}	

				// to set obTroFlg, ibTroFlg
				prdPcCreateVo.setObTroFlg(obTroFlg);
				prdPcCreateVo.setIbTroFlg(ibTroFlg);
				
				prdPatternVO.setObItchgCtnt(outStr) ;   
				prdPatternVO.setOcnItchgCtnt(ocnStr) ; 
				prdPatternVO.setIbItchgCtnt(inStr) ;
				
				// qty 생성
				prdCreateManageBc.createContainerQty(event);	
//				// data 정리 (min, max pc no )
				prdCreateManageBc.dataArrangement(event);
				log.debug("\n\n -------------dataArrangement 종료----------------------");
				prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo,prdPatternVO,creUsrId );
				log.debug("\n\n -------------createActivityGroup 종료----------------------");
				prdCreateManageBc.updateActivityGroup(hdPctlNo);
				log.debug("\n\n -------------createActivityGroup 종료----------------------");
				
				retPctlNo = prdPcCreateVo.getMinPctlNo();
			} 
			//---------------------------------------------------------------------------------------------------------
	
		}catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return retPctlNo;
	}
	
	
	/**
	 * @param bkgNo
	 * @param outStr
	 * @param inStr
	 * @param ocnStr
	 * @param smtPu
	 * @param smtRtn
	 * @param obTroFlg
	 * @param ibTroFlg
	 * @param porNodCd
	 * @param polNodCd
	 * @param srTerm
	 * @param sdTerm
	 * @param ibTrspMode 
	 * @param obTrspMode 
	 * @param fullPkUpYdCd 
	 * @param fullRtnYdCd 
	 * @param delNodCd 
	 * @return
	 * @throws EventException
	 */
	private String searchSameRoutSce(String bkgNo, String outStr, String inStr,
			String ocnStr, String smtPu, String smtRtn, String obTroFlg,
			String ibTroFlg, String porNodCd, String polNodCd, String srTerm,
			String sdTerm, String delNodCd, String fullRtnYdCd, String fullPkUpYdCd, String obTrspMode, String ibTrspMode) throws EventException{
		
		String pctlNo="";
		try {
			pctlNo = dbDaoSce.searchSameRoutSce( bkgNo,  outStr,  inStr,
					 ocnStr,  smtPu,  smtRtn,  obTroFlg,
					 ibTroFlg,  porNodCd,  polNodCd,  srTerm,
					 sdTerm, delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode);

		}catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return pctlNo;
	}

 
	/**
	 * terminal change(T)시 에는 same route를 찾지 않고 바로 다음 스텝으로 넘어간다.
	 * ->same route로 찾으면 terminal 이 변경된게 반영안될수 있기 때문에
	 * terminal change 는 cop배치에서 호출.
	 * @param copNo
	 * @param ioBndCd
	 * @param creUsrId
	 * @return 
	 * @throws EventException
	 */
	public String createSceSoReplan(String copNo,String ioBndCd ,String creUsrId) throws EventException{
		EsdPrd0080Event event = new EsdPrd0080Event(); 
//		EventResponse eventResponse = new GeneralEventResponse();
		String retPctlNo="";
		try{
			
			// pc no 생성 
			PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
			PrdCreateParamVO  prdCreateParamVO = new PrdCreateParamVO();
//			PrdCreateParamVO  prdCreateParamVO = event.getPrdCreateParamVO();
			PrdPatternVO prdPatternVO = new PrdPatternVO();
			
			String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);
			prdCreateParamVO.setPcMode(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);
			
//			DBRowSet getParams = null;
			List<PrdSceGetParamVO> sceGetParamList = null;
//			DBRowSet subRoutParam = null;
			
			// pc return value object create
			PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
			// pc_no_head set		
			prdPcCreateVo.setHdPctlNo(hdPctlNo);
			// Merchant Haulage 처리를 위해 cop_no 추가
			prdPcCreateVo.setCopNo(copNo);
			prdPcCreateVo.setIdaHlgTpCd(prdCreateParamVO.getIdaHlgTpCd());
			
			event.setPrdPcCreateVO(prdPcCreateVo);
//------------------
			String pcMode = "";
			String doorZn = "";
			String fullRtnCy = "";
			String fullPuCy = "";
			String mtPu = "";
			String mtRtn = "";
 
			pcMode = prdCreateParamVO.getPcMode();
 
//-------------------------------			

			String srTerm = "";
			String sdTerm = "";
			String cct = "";
			String pmF = "";
			String podT = "";
			String polT = "";
			String spmFlg = "";
			String srfCntr = prdCreateParamVO.getRfF();
			String smtPu = "";
			String smtRtn = "";
			String inlndRoutOrg = "";
			String inlndRoutDest = "";
			String sinclShtlSoFlg =  "";
			String subRout = "";
			String fullCy = "";
			String trspModCd = prdCreateParamVO.getTrMode();
			String stermNode = "";
			String prdCtlNo = "";
			String outStr   =     "";
			String inStr    =     "";
			String ocnStr   =     "";
			String obTroFlg =     "";
			String ibTroFlg =     "";
			String porNodCd =     "";
			String polNodCd =     "";
			String delNodCd =     "";
			String fullRtnYdCd =  "";
			String fullPkUpYdCd = "";
			String obTrspMode =   "";
			String ibTrspMode =   "";
			
			//sce에서  넘겨줘야 함.(cop_no, io_bnd_cd)
			sceGetParamList = dbDaoSce.sceGetParam(copNo, ioBndCd, pcMode, doorZn, fullRtnCy, fullPuCy, mtPu, mtRtn );
			PrdSceGetParamVO prdSceGetParamVO = null;
			if(sceGetParamList != null && sceGetParamList.size()>0) {
				prdSceGetParamVO = (PrdSceGetParamVO)sceGetParamList.get(0);
				srTerm = JSPUtil.getNull(prdSceGetParamVO.getRcvTermCd());
				sdTerm = JSPUtil.getNull(prdSceGetParamVO.getDeTermCd());
				cct    = JSPUtil.getNull(prdSceGetParamVO.getCct());
				podT   = JSPUtil.getNull(prdSceGetParamVO.getPodT());
				polT   = JSPUtil.getNull(prdSceGetParamVO.getPolT());
				smtPu  = JSPUtil.getNull(prdSceGetParamVO.getMtPu());
				smtRtn = JSPUtil.getNull(prdSceGetParamVO.getMtRtn());
				// I/O Bound에 따라 Included Shuttle S/O Flag 구분  - #Mod - 2010.05.27 by sj
				sinclShtlSoFlg = JSPUtil.getNull(prdSceGetParamVO.getIoBndCd()).equals("I")?JSPUtil.getNull(prdSceGetParamVO.getIbInclShtlSoFlg()):JSPUtil.getNull(prdSceGetParamVO.getObInclShtlSoFlg());
				prdCtlNo = JSPUtil.getNull(prdSceGetParamVO.getPctlNo());
				//COP_SEARCH_SAME_ROUTE.txt 를 실행해서 PCTL_NO가 있으면 리턴하고 끝.-----------------------------------------
				outStr   = JSPUtil.getNull(prdSceGetParamVO.getOutBound());
				inStr    = JSPUtil.getNull(prdSceGetParamVO.getInBound());
				ocnStr   = JSPUtil.getNull(prdSceGetParamVO.getOcnBound());
				inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getRoutOrgNodCd());
				inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getRoutDestNodCd());
				
				if(ioBndCd.equals("O")) {
					subRout = outStr ;
					//door so가 있을경우 
					log.debug("\n o/b inlndRoutOrg before: "+inlndRoutOrg);
					inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd()).equals("")? inlndRoutOrg :prdSceGetParamVO.getPorNodCd() ;
					log.debug("\n o/b inlndRoutOrg after: "+inlndRoutOrg);
				}else if (ioBndCd.equals("I")) {
					subRout = inStr ;
					//door so가 있을경우 
					log.debug("\n i/b inlndRoutDest before: "+inlndRoutDest);
					inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getDelNodCd()).equals("")? inlndRoutDest: prdSceGetParamVO.getDelNodCd() ;
					log.debug("\n i/b inlndRoutDest after: "+inlndRoutDest);
				}else if (ioBndCd.equals("T")){
					subRout = ocnStr ;
				}
				obTroFlg = JSPUtil.getNull(prdSceGetParamVO.getObTroFlg());
				ibTroFlg = JSPUtil.getNull(prdSceGetParamVO.getIbTroFlg());
				porNodCd = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd());
				polNodCd = JSPUtil.getNull(prdSceGetParamVO.getPolYdCd());
				delNodCd = JSPUtil.getNull(prdSceGetParamVO.getDelNodCd());
				fullRtnYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullRtnYdCd());
				fullPkUpYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullPkupYdCd());
				if(pcMode.equals("O")) {
					obTrspMode = JSPUtil.getNull(prdCreateParamVO.getObTrspMode()) ;
				}else {
					obTrspMode = JSPUtil.getNull(prdSceGetParamVO.getObTrspMode());
				} 
				
				if(pcMode.equals("I")) {
					ibTrspMode = JSPUtil.getNull(prdCreateParamVO.getIbTrspMode()) ;
				}else {
					ibTrspMode = JSPUtil.getNull(prdSceGetParamVO.getIbTrspMode());
				}			
				
//			}
//			if(list != null && list.size()>0) {
//				prdSceGetParamVO = (PrdSceGetParamVO)list.get(0);
				 
				//inbound/outbound 일경우 수행.
//				if(ioBndCd.equals("O") || ioBndCd.equals("I") ) {
//					
//					retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(),outStr, inStr, ocnStr, smtPu ,
//							smtRtn, obTroFlg, ibTroFlg, porNodCd, polNodCd, srTerm, sdTerm, 
//							delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode );
//					log.debug("\n\n searchSameRoutSce pctl_no:"+retPctlNo);
//				}
				if(ioBndCd.equals("O")) {
					retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(),outStr, inStr, ocnStr, smtPu ,
							smtRtn, obTroFlg, ibTroFlg, inlndRoutOrg, polNodCd, srTerm, sdTerm, 
							delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode );
					log.debug("\n\n searchSameRoutSce pctl_no:"+retPctlNo);
				} else if(ioBndCd.equals("O")) {
					retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(),outStr, inStr, ocnStr, smtPu ,
							smtRtn, obTroFlg, ibTroFlg, porNodCd, polNodCd, srTerm, sdTerm, 
							inlndRoutDest, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode );
					log.debug("\n\n searchSameRoutSce pctl_no:"+retPctlNo);
					
				}
				
				// Ocn 구간이거나 searchSameRoutSce 의 결과가 "" 일때.
				if(retPctlNo.equals("")){
					// Ocn 구간(T)이거나 searchSameRoutSce 의 결과에서 newPol 또는 newPod에 값이 있으면 location 이 달라진경우로 pc를 새로 생성 .
					int successCnt = 0;
					String pcVerifyMsg = "";
					if(ioBndCd.equals("T") ) {//T 일때   || !prdSceGetParamVO.getNewPol().equals("") || !prdSceGetParamVO.getNewPod().equals("")){
						// COP_AUTO_CHANGE_OCN_INLAND_CHANGE.txt 실행.  
						// prd mst, dtl 생성 
						successCnt = dbDaoSce.createSceSoReplaneOcnInlndChange(prdSceGetParamVO,hdPctlNo);
//						if(successCnt == 0){
//							
//							try {
//								pcVerifyMsg = dbDaoSce.createSceSoReplaneOcnInlndChangeVerify(prdSceGetParamVO,hdPctlNo);
//								log.debug("\n\n createSceSoReplaneOcnInlndChangeVerify:"+pcVerifyMsg);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
						
 					
					} else {
						// 변경된 바운드만 pc를 만들고 나머지는 기존 pc를 가져와서 붙인다.
						if(pcMode.equals("O")) {
							trspModCd = obTrspMode;
						}else if(pcMode.equals("I")) {
							trspModCd = ibTrspMode;
						}
						successCnt =dbDaoTro.troAutoChange(ioBndCd, srTerm, sdTerm, creUsrId, hdPctlNo, cct, pmF, podT, polT, spmFlg, srfCntr, smtPu, smtRtn, inlndRoutOrg, inlndRoutDest, sinclShtlSoFlg, subRout, fullCy, trspModCd, stermNode, prdCtlNo);
					}
					
//					// Auto IRG를 생성해야하는지 검사하고, 필요시 생성한다. 20100713
//					prdCreateManageBc.createAutoIRG(hdPctlNo, creUsrId, "");
					
					if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
						log.debug("\n\n PRD log On:");
						Map map = new HashMap();
						
						map.put("prdSceGetParamVO", prdSceGetParamVO);
						map.put("PrdCreateParamVO", prdCreateParamVO);
						map.put("hdPctlNo", hdPctlNo);
						
						map.put("ioBndCd",          ioBndCd        );      
						map.put("srTerm",           srTerm         );
						map.put("sdTerm",           sdTerm         );
						map.put("creUsrId",         creUsrId       );
						map.put("hdPctlNo",         hdPctlNo       );
						map.put("cct",              cct            );
						map.put("pmF",              pmF            );
						map.put("podT",             podT           );
						map.put("polT",             polT           );
						map.put("spmFlg",           spmFlg         );
						map.put("srfCntr",          srfCntr        );
						map.put("smtPu",            smtPu          );
						map.put("smtRtn",           smtRtn         );
						map.put("inlndRoutOrg",     inlndRoutOrg   );
						map.put("inlndRoutDest",    inlndRoutDest  );
						map.put("sinclShtlSoFlg",   sinclShtlSoFlg );
						// I/O Included Shuttle S/O Flag - #Add 2010.05.27 by sj
						map.put("ibInclShtlSoFlg",  prdSceGetParamVO.getIbInclShtlSoFlg() );
						map.put("obInclShtlSoFlg",  prdSceGetParamVO.getObInclShtlSoFlg() );
						map.put("subRout",          subRout        );
						map.put("fullCy",           fullCy         );
						map.put("trspModCd",        trspModCd      );
						map.put("stermNode",        stermNode      );
						map.put("prdCtlNo",         prdCtlNo       );
						map.put("pcVerifyMsg",      pcVerifyMsg    );
						
						String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
						log.debug("\n\n log::::"+logDesc );
					
						
//						dbDao.createPrdExecEnisLog(log_desc,app_info);
						dbDao.createPrdExecEnisLog(logDesc ,"createSceSoReplan", creUsrId);
					}
					
					// 공용 메소드를 위해 event에 param setting
					prdCreateParamVO.setTVvd(prdSceGetParamVO.getTVvd());
					event.setPrdCreateParamVO(prdCreateParamVO);

					// to set obTroFlg, ibTroFlg
					prdPcCreateVo.setObTroFlg(obTroFlg);
					prdPcCreateVo.setIbTroFlg(ibTroFlg);					
					
					prdPatternVO.setObItchgCtnt(outStr) ;   
					prdPatternVO.setOcnItchgCtnt(ocnStr) ; 
					prdPatternVO.setIbItchgCtnt(inStr) ;
					
					 
					// qty 생성 (enis 에서도 auto change시  qty는 안만들고 있음)
//					prdCreateManageBc.createContainerQty(event);	
					
					// data 정리 (min, max pc no )
					prdCreateManageBc.dataArrangement(event);
					log.debug("\n\n -------------dataArrangement 종료----------------------");
					prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo,prdPatternVO,creUsrId );
					log.debug("\n\n -------------createActivityGroup 종료----------------------");
					prdCreateManageBc.updateActivityGroup(hdPctlNo);
					log.debug("\n\n -------------createActivityGroup 종료----------------------");
					retPctlNo = prdPcCreateVo.getMinPctlNo();
					log.debug("\n\n -------------createSceSoReplan 종료----------------------" +
							"\n return PCTL NO : "+ retPctlNo);					
				} 
			} else { //param list가  null 일때.
//				throw new EventException("sceGetParam fail.");
				throw new EventException(new ErrorHandler("PRD00061").getMessage());
			}
			

		}catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return retPctlNo;
	}
	
	/**
	 * @param copNo
	 * @param ioBndCd
	 * @param creUsrId
	 * @return
	 * @throws EventException
	 */
	public String createSceSoReplanByBkgInfo(String copNo,String ioBndCd ,String creUsrId) throws EventException{
		EsdPrd0080Event event = new EsdPrd0080Event(); 
//		EventResponse eventResponse = new GeneralEventResponse();
		String retPctlNo="";
		try{
			
			// pc no 생성 
			PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
			PrdCreateParamVO  prdCreateParamVO = new PrdCreateParamVO();
//			PrdCreateParamVO  prdCreateParamVO = event.getPrdCreateParamVO();
			PrdPatternVO prdPatternVO = new PrdPatternVO();
			
			String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);
			prdCreateParamVO.setPcMode(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);
			
//			DBRowSet getParams = null;
			List<PrdSceGetParamVO> list = null;
//			DBRowSet subRoutParam = null;
			
			// pc return value object create
			PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
			// pc_no_head set		
			prdPcCreateVo.setHdPctlNo(hdPctlNo);
			// Merchant Haulage 처리를 위해 cop_no 추가
			prdPcCreateVo.setCopNo(copNo);
			prdPcCreateVo.setIdaHlgTpCd(prdCreateParamVO.getIdaHlgTpCd());
			
			event.setPrdPcCreateVO(prdPcCreateVo);
//------------------
			String pcMode = "";
			String doorZn = "";
			String fullRtnCy = "";
			String fullPuCy = "";
			String mtPu = "";
			String mtRtn = "";
 
			pcMode = prdCreateParamVO.getPcMode();
 
//-------------------------------			

			String srTerm = "";
			String sdTerm = "";
			String cct = "";
			String pmF = "";
			String podT = "";
			String polT = "";
			String spmFlg = "";
			String srfCntr = prdCreateParamVO.getRfF();
			String smtPu = "";
			String smtRtn = "";
			String inlndRoutOrg = "";
			String inlndRoutDest = "";
			String sinclShtlSoFlg =  "";
			String subRout = "";
			String fullCy = "";
			String trspModCd = prdCreateParamVO.getTrMode();
			String stermNode = "";
			String prdCtlNo = "";
			String outStr   =     "";
			String inStr    =     "";
			String ocnStr   =     "";
			String obTroFlg =     "";
			String ibTroFlg =     "";
			String porNodCd =     "";
			String polNodCd =     "";
			String delNodCd =     "";
			String fullRtnYdCd =  "";
			String fullPkUpYdCd = "";
			String obTrspMode =   "";
			String ibTrspMode =   "";
			
			//sce에서  넘겨줘야 함.(cop_no, io_bnd_cd)
			list = dbDaoSce.sceBkgGetParam(copNo, ioBndCd, pcMode, doorZn, fullRtnCy, fullPuCy, mtPu, mtRtn );
			PrdSceGetParamVO prdSceGetParamVO = null;
			if(list != null && list.size()>0) {
				prdSceGetParamVO = (PrdSceGetParamVO)list.get(0);
				srTerm = JSPUtil.getNull(prdSceGetParamVO.getRcvTermCd());
				sdTerm = JSPUtil.getNull(prdSceGetParamVO.getDeTermCd());
				cct    = JSPUtil.getNull(prdSceGetParamVO.getCct());
				podT   = JSPUtil.getNull(prdSceGetParamVO.getPodT());
				polT   = JSPUtil.getNull(prdSceGetParamVO.getPolT());
				smtPu  = JSPUtil.getNull(prdSceGetParamVO.getMtPu());
				smtRtn = JSPUtil.getNull(prdSceGetParamVO.getMtRtn());
				// I/O Bound에 따라 Included Shuttle S/O Flag 구분  - #Mod - 2010.05.27 by sj
				sinclShtlSoFlg = JSPUtil.getNull(prdSceGetParamVO.getIoBndCd()).equals("I")?JSPUtil.getNull(prdSceGetParamVO.getIbInclShtlSoFlg()):JSPUtil.getNull(prdSceGetParamVO.getObInclShtlSoFlg());
				prdCtlNo = JSPUtil.getNull(prdSceGetParamVO.getPctlNo());
				//COP_SEARCH_SAME_ROUTE.txt 를 실행해서 PCTL_NO가 있으면 리턴하고 끝.-----------------------------------------
				outStr   = JSPUtil.getNull(prdSceGetParamVO.getOutBound());
				inStr    = JSPUtil.getNull(prdSceGetParamVO.getInBound());
				ocnStr   = JSPUtil.getNull(prdSceGetParamVO.getOcnBound());
				inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getRoutOrgNodCd());
				inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getRoutDestNodCd());
				
				if(ioBndCd.equals("O")) {
					subRout = outStr ;
					//door so가 있을경우 
					log.debug("\n o/b inlndRoutOrg before: "+inlndRoutOrg);
					inlndRoutOrg = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd()).equals("")? inlndRoutOrg :prdSceGetParamVO.getPorNodCd() ;
					log.debug("\n o/b inlndRoutOrg after: "+inlndRoutOrg);
				}else if (ioBndCd.equals("I")) {
					subRout = inStr ;
					//door so가 있을경우 
					log.debug("\n i/b inlndRoutDest before: "+inlndRoutDest);
					inlndRoutDest = JSPUtil.getNull(prdSceGetParamVO.getDelNodCd()).equals("")? inlndRoutDest: prdSceGetParamVO.getDelNodCd() ;
					log.debug("\n i/b inlndRoutDest after: "+inlndRoutDest);
				}else if (ioBndCd.equals("T")){
					subRout = ocnStr ;
				}
				obTroFlg = JSPUtil.getNull(prdSceGetParamVO.getObTroFlg());
				ibTroFlg = JSPUtil.getNull(prdSceGetParamVO.getIbTroFlg());
				porNodCd = JSPUtil.getNull(prdSceGetParamVO.getPorNodCd());
				polNodCd = JSPUtil.getNull(prdSceGetParamVO.getPolYdCd());
				delNodCd = JSPUtil.getNull(prdSceGetParamVO.getDelNodCd());
				fullRtnYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullRtnYdCd());
				fullPkUpYdCd = JSPUtil.getNull(prdSceGetParamVO.getFullPkupYdCd());
				if(pcMode.equals("O")) {
					obTrspMode = JSPUtil.getNull(prdCreateParamVO.getObTrspMode()) ;
				}else {
					obTrspMode = JSPUtil.getNull(prdSceGetParamVO.getObTrspMode());
				} 
				
				if(pcMode.equals("I")) {
					ibTrspMode = JSPUtil.getNull(prdCreateParamVO.getIbTrspMode()) ;
				}else {
					ibTrspMode = JSPUtil.getNull(prdSceGetParamVO.getIbTrspMode());
				}			
				
				// validation check 하지 않도록 param 추가
				prdSceGetParamVO.setSkipActValFlg("Y");
				
//			}
//			if(list != null && list.size()>0) {
//				prdSceGetParamVO = (PrdSceGetParamVO)list.get(0);
				 
				//inbound/outbound 일경우 수행.
//				if(ioBndCd.equals("O") || ioBndCd.equals("I") ) {
//					
//					retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(),outStr, inStr, ocnStr, smtPu ,
//							smtRtn, obTroFlg, ibTroFlg, porNodCd, polNodCd, srTerm, sdTerm, 
//							delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode );
//					log.debug("\n\n searchSameRoutSce pctl_no:"+retPctlNo);
//				}
				if(ioBndCd.equals("O")) {
					retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(),outStr, inStr, ocnStr, smtPu ,
							smtRtn, obTroFlg, ibTroFlg, inlndRoutOrg, polNodCd, srTerm, sdTerm, 
							delNodCd, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode );
					log.debug("\n\n searchSameRoutSce pctl_no:"+retPctlNo);
				} else if(ioBndCd.equals("I")) {
					retPctlNo = searchSameRoutSce(prdCreateParamVO.getBkgNo(),outStr, inStr, ocnStr, smtPu ,
							smtRtn, obTroFlg, ibTroFlg, porNodCd, polNodCd, srTerm, sdTerm, 
							inlndRoutDest, fullRtnYdCd, fullPkUpYdCd, obTrspMode, ibTrspMode );
					log.debug("\n\n searchSameRoutSce pctl_no:"+retPctlNo);
			
				}
				
				// Ocn 구간이거나 searchSameRoutSce 의 결과가 "" 일때.
				if(retPctlNo.equals("")){
					// Ocn 구간(T)이거나 searchSameRoutSce 의 결과에서 newPol 또는 newPod에 값이 있으면 location 이 달라진경우로 pc를 새로 생성 .
					int successCnt = 0;
					if(ioBndCd.equals("T") ) {//T 일때   || !prdSceGetParamVO.getNewPol().equals("") || !prdSceGetParamVO.getNewPod().equals("")){
						// COP_AUTO_CHANGE_OCN_INLAND_CHANGE.txt 실행.  
						// prd mst, dtl 생성 
						successCnt = dbDaoSce.createSceSoReplaneOcnInlndChange(prdSceGetParamVO,hdPctlNo);
 					
					} else {
						// 변경된 바운드만 pc를 만들고 나머지는 기존 pc를 가져와서 붙인다.
						if(pcMode.equals("O")) {
							trspModCd = obTrspMode;
						}else if(pcMode.equals("I")) {
							trspModCd = ibTrspMode;
						}
						successCnt =dbDaoTro.troAutoChange(ioBndCd, srTerm, sdTerm, creUsrId, hdPctlNo, cct, pmF, podT, polT, spmFlg, srfCntr, smtPu, smtRtn, inlndRoutOrg, inlndRoutDest, sinclShtlSoFlg, subRout, fullCy, trspModCd, stermNode, prdCtlNo);
					}
					
//					// Auto IRG를 생성해야하는지 검사하고, 필요시 생성한다. 20100713
//					prdCreateManageBc.createAutoIRG(hdPctlNo, creUsrId, "");
					
					if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
						log.debug("\n\n PRD log On:");
						Map map = new HashMap();
						
						map.put("prdSceGetParamVO", prdSceGetParamVO);
						map.put("PrdCreateParamVO", prdCreateParamVO);
						map.put("hdPctlNo", hdPctlNo);
						
						map.put("ioBndCd",          ioBndCd        );      
						map.put("srTerm",           srTerm         );
						map.put("sdTerm",           sdTerm         );
						map.put("creUsrId",         creUsrId       );
						map.put("hdPctlNo",         hdPctlNo       );
						map.put("cct",              cct            );
						map.put("pmF",              pmF            );
						map.put("podT",             podT           );
						map.put("polT",             polT           );
						map.put("spmFlg",           spmFlg         );
						map.put("srfCntr",          srfCntr        );
						map.put("smtPu",            smtPu          );
						map.put("smtRtn",           smtRtn         );
						map.put("inlndRoutOrg",     inlndRoutOrg   );
						map.put("inlndRoutDest",    inlndRoutDest  );
						map.put("sinclShtlSoFlg",   sinclShtlSoFlg );
						// I/O Included Shuttle S/O Flag - #Add 2010.05.27 by sj
						map.put("ibInclShtlSoFlg",  prdSceGetParamVO.getIbInclShtlSoFlg() );
						map.put("obInclShtlSoFlg",  prdSceGetParamVO.getObInclShtlSoFlg() );
						map.put("subRout",          subRout        );
						map.put("fullCy",           fullCy         );
						map.put("trspModCd",        trspModCd      );
						map.put("stermNode",        stermNode      );
						map.put("prdCtlNo",         prdCtlNo       );
						
						String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
						log.debug("\n\n log::::"+logDesc );
					
						
//						dbDao.createPrdExecEnisLog(log_desc,app_info);
						dbDao.createPrdExecEnisLog(logDesc ,"createSceSoReplanByBkgInfo", creUsrId);
					}
					
					// 공용 메소드를 위해 event에 param setting
					prdCreateParamVO.setTVvd(prdSceGetParamVO.getTVvd());
					event.setPrdCreateParamVO(prdCreateParamVO);

					// to set obTroFlg, ibTroFlg
					prdPcCreateVo.setObTroFlg(obTroFlg);
					prdPcCreateVo.setIbTroFlg(ibTroFlg);
					
					prdPatternVO.setObItchgCtnt(outStr) ;   
					prdPatternVO.setOcnItchgCtnt(ocnStr) ; 
					prdPatternVO.setIbItchgCtnt(inStr) ;
					
					 
					// qty 생성 (enis 에서도 auto change시  qty는 안만들고 있음)
//					prdCreateManageBc.createContainerQty(event);	
					
					// data 정리 (min, max pc no )
					prdCreateManageBc.dataArrangement(event);
					log.debug("\n\n -------------dataArrangement 종료----------------------");
					prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo,prdPatternVO,creUsrId );
					log.debug("\n\n -------------createActivityGroup 종료----------------------");
					prdCreateManageBc.updateActivityGroup(hdPctlNo);
					log.debug("\n\n -------------createActivityGroup 종료----------------------");
					retPctlNo = prdPcCreateVo.getMinPctlNo();
					log.debug("\n\n -------------createSceSoReplan 종료----------------------" +
							"\n return PCTL NO : "+ retPctlNo);					
				} 
			} else { //param list가  null 일때.
//				throw new EventException("sceGetParam fail.");
				throw new EventException(new ErrorHandler("PRD00061").getMessage());
			}
			

		}catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return retPctlNo;
	}
	
	/**
	 * terminal change(T)시 에는 same route를 차지 않고 바로 다음 스텝으로 넘어간다.
	 * ->same route로 찾으면 terminal 이 변경된게 반영안될수 있기 때문에
	 * 
	 * Sce 의 oltp 에서 호출 
	 * @param copNo
	 * @param ioBndCd
	 * @param newNod
	 * @param creUsrId
	 * @return String
	 * @throws EventException
	 */
	public String createSceManualReplan(String copNo,String ioBndCd ,String newNod, String creUsrId) throws EventException{
		EsdPrd0080Event event = new EsdPrd0080Event();
		String hdPctlNo = "" ;
		
		String retPctlNo="";
		try{
			
			// pc no 생성 
			PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
			PrdCreateParamVO  prdCreateParamVO = new PrdCreateParamVO();
//			PrdCreateParamVO  prdCreateParamVO = event.getPrdCreateParamVO();
			PrdPatternVO prdPatternVO = new PrdPatternVO();
			
			hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);
			prdCreateParamVO.setPcMode(PrdConstants.PRD_PC_MOD_SCE_SO_REPLAN);			

			List<PrdSceGetParamVO> sceGetParamList = null;

			
			// pc return value object create
			PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
			// pc_no_head set		
			prdPcCreateVo.setHdPctlNo(hdPctlNo);
			// Merchant Haulage 처리를 위해 cop_no 추가
			prdPcCreateVo.setCopNo(copNo);
			prdPcCreateVo.setIdaHlgTpCd(prdCreateParamVO.getIdaHlgTpCd());
			
			event.setPrdPcCreateVO(prdPcCreateVo);
//------------------
			String pcMode = "";
			String doorZn = "";
			String fullRtnCy = "";
			String fullPuCy = "";
			String mtPu = "";
			String mtRtn = "";
 
			pcMode = prdCreateParamVO.getPcMode();
 
//-------------------------------	
						
			//sce에서  넘겨줘야 함.(cop_no, io_bnd_cd)
			sceGetParamList = dbDaoSce.sceGetParam(copNo, ioBndCd, pcMode, doorZn, fullRtnCy, fullPuCy, mtPu, mtRtn );
			
			PrdSceGetParamVO prdSceGetParamVO = null;
			if(sceGetParamList != null && sceGetParamList.size()>0) {
				prdSceGetParamVO = (PrdSceGetParamVO)sceGetParamList.get(0);
				
				if (ioBndCd.equals("O") && newNod!=null && !newNod.equals("") ){
					prdSceGetParamVO.setRoutOrgNodCd(newNod) ;
//					prdSceGetParamVO.setOutBound("");
					prdSceGetParamVO.setPorNodCd(newNod);
					prdSceGetParamVO.setPorCd(newNod.substring(0,5));
					prdSceGetParamVO.setFullRtnYdCd("");
					prdSceGetParamVO.setObTrspMode("");
					
				}else if(ioBndCd.equals("O") && ( newNod==null ||newNod.equals("") )) {
//					prdSceGetParamVO.setOutBound(prdSceGetParamVO.getOutBound());
					prdSceGetParamVO.setFullRtnYdCd(prdSceGetParamVO.getFullRtnYdCd());
					prdSceGetParamVO.setObTrspMode(prdSceGetParamVO.getObTrspMode());
				}
				
				if (ioBndCd.equals("I") && newNod!=null && !newNod.equals("") ){
					prdSceGetParamVO.setRoutDestNodCd(newNod);					
//					prdSceGetParamVO.setInBound("");
					prdSceGetParamVO.setDelNodCd(newNod);
					prdSceGetParamVO.setDelCd(newNod.substring(0,5));
					prdSceGetParamVO.setFullPkupYdCd("");
					prdSceGetParamVO.setIbTrspMode("") ;
				}else if(ioBndCd.equals("I") && ( newNod==null ||newNod.equals("") )) {
//					prdSceGetParamVO.setInBound("");
					prdSceGetParamVO.setFullPkupYdCd("");
					prdSceGetParamVO.setIbTrspMode("");
				}
				
				prdSceGetParamVO.setManualFlag("Y") ;	
				
				// Manual change의 경우 전체 route를 대상으로 아래 method 호출하고 tro와 공용하지 않음.
				int successCnt = dbDaoSce.createSceSoReplaneOcnInlndChange(prdSceGetParamVO,hdPctlNo);
				
//				// Auto IRG를 생성해야하는지 검사하고, 필요시 생성한다. 20100713
//				prdCreateManageBc.createAutoIRG(hdPctlNo, creUsrId, "");
				
				if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					
					map.put("PrdSceGetParamVO", prdSceGetParamVO);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", "SCE");
					map.put("pcMode", pcMode);
					map.put("newNod", newNod);
					
					String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					
//					dbDao.createPrdExecEnisLog(log_desc,app_info, id);
					dbDao.createPrdExecEnisLog(logDesc ,"createSceManualReplan", "SCE");
				}

				// 공용 메소드를 위해 event에 param setting
				prdCreateParamVO.setTVvd(prdSceGetParamVO.getTVvd());
				event.setPrdCreateParamVO(prdCreateParamVO);
					
					 
				// qty 생성 (enis 에서도 auto change시  qty는 안만들고 있음)
//				prdCreateManageBc.createContainerQty(event);	
				prdPatternVO.setObItchgCtnt(JSPUtil.getNull(prdSceGetParamVO.getOutBound())) ;   
				prdPatternVO.setOcnItchgCtnt(JSPUtil.getNull(prdSceGetParamVO.getOcnBound())) ; 
				prdPatternVO.setIbItchgCtnt(JSPUtil.getNull(prdSceGetParamVO.getInBound())) ;				
					
				// data 정리 (min, max pc no )
				prdCreateManageBc.dataArrangement(event);
				log.debug("\n\n -------------dataArrangement 종료----------------------");
				prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo,prdPatternVO,creUsrId );
				log.debug("\n\n -------------createActivityGroup 종료----------------------");
				prdCreateManageBc.updateActivityGroup(hdPctlNo);
				log.debug("\n\n -------------createActivityGroup 종료----------------------");
				retPctlNo = prdPcCreateVo.getMinPctlNo();
				log.debug("\n\n -------------createSceSoReplan 종료----------------------" +
							"\n return PCTL NO : "+ retPctlNo);					
			
			} else { //list가  null 일때.
//				throw new EventException("sceGetParam fail.");
				// SCE MENUAL REPLAN PARAMETER SEARCH NOT AVAILABLE. 
				throw new EventException(new ErrorHandler("PRD00061").getMessage());
			}

		}catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return hdPctlNo;
	}	
	
	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse processReplaneFinish(Event e) throws EventException {
		// TODO Auto-generated method stub
		EsdPrd0080Event event = (EsdPrd0080Event)e;
//		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		List<PrdPatternVO> list = null;
		EventResponse eventResponse = new GeneralEventResponse();
		String eurDrChk =null ;
		/*
		 * SC 의 createPrdCtlgFullRout 는 선택화면을 위한 메소드
		 * PC를 생성하고, 선택화면에 필요한 데이터를 위해 조회를 한다.
		 */		
		//replane 시  맵테이블을 만든 map sequence를 받는다.
		String mapSeq = prdCreateParamVO.getMapSeq();
		log.debug("\n\n replane 부패턴 처리-----------------------------------" +
				"\n processReplaneFinish ------------------------------------ "+
	             "\n mapSeq : "+mapSeq);
		// 선택한  주패턴(1)에  pc no로 맵테이블 업데이트.
//		this.updatePrdMapByPcNo(mapSeq,prdCreateParamVO.getBkgNo(),prdCreateParamVO.getMainPatternPctlNo(), "1");
		
		if(prdCreateParamVO.getPcMode().equals(PrdConstants.PRD_PC_MOD_REPLAN)){
			
			
			// 만들어진 패턴을 읽는다.
			list = this.getReplanePatternByMapSeq(mapSeq);
			if(list != null){
				
				log.debug("\n\n replane 부패턴 처리-----------------------------------" +
				"\n list.size:"+ list.size()+
				"--------------------------------------------------------------------");			
				// 주 패턴을 제외한다.
				if(list != null && list.size()>0){
					log.debug("\n\n 주 패턴을 제외한다.----------------");
					list.remove(0);
					log.debug("\n  주 패턴을 제외후 list.size:"+ list.size());
				}
			
			//부패턴리스트 
			event.setAttribute("PATTERN_LIST", list);
			}else{
				event.setAttribute("PATTERN_LIST", "");
			}
 
			//주패턴을 제외한 리스트가 있으면 
			if(list !=null && list.size() > 0){
				log.debug("\n ord > 1 인 부패턴으로 pc를 생성한다.list.size:"+ list.size());
				//ord > 1 인 부패턴으로 pc를 생성한다.
				PrdPatternVO prdPatternVO = (PrdPatternVO)list.get(0);
				eventResponse.setETCData("map_seq", prdPatternVO.getCopMapgSeq());
//-------------------------------------------------------------------------------------------------------------------				
				/*
				 * 부패턴 pc생성
				 * prd mst,dtl 생성
				 * qty 생성
				 * data 정리 
				 * activity group dtl 생성
				 */
				//부패턴이 생성한 pc가 1개이상일때 주패턴의 ocn route가 있는 pc를 선택하고, 없으면 rounum =1로 선택
				//선택된 pc로 map 테이블 업데이트
				this.createSubPatternPrdCtlgFullRout(e); //pc 생성 (mst,dtl,qty,act)
				
//				// EUR TRO 처리 시작
//				// 1. EUR TRO 처리가 있는 지 확인한다.
//				// 2. ERU TRO 처리가 필요한 PATTERN으로 다시 조사한다.-- 기존 PATTERN 무시
//				//    --> 1) POR/DEL NODE와 다른 구주 지역의 S/O나 TRO가 있으면 
//				//        2) S/O있으면 S/O 우선 없으면 TRO DATA SEARCH
//				// 3. 새로운 형태로 TRO PC를 생성하고 PC NO를 UPDATE 한다.
//
//				event.setAttribute("eur_dr_seq", mapSeq);
//					
//				try {
//					eurDrChk = dbDao.chkEurDr(prdCreateParamVO.getBkgNo()) ;
//					
//					if(eurDrChk.equals("Y")) {
//			            // 새로 변경할 것만 pattern ord 신규로 setting
//						dbDao.updatePrdMapReInit(prdCreateParamVO.getBkgNo(),event.getAttribute("eur_dr_seq")+"") ;
//						
//						// 작업 대상 select
//						List<PrdSearchEurDrRePatternVO> eurDrList = dbDao.getEurDr(prdCreateParamVO.getBkgNo(),event.getAttribute("eur_dr_seq")+"") ;	
//						
//						// pc 생성
//						PrdSearchEurDrRePatternVO prdSearchEurDrRePatternVO = null;
//						for(int i=0; i<eurDrList.size(); i++){
//							
//							prdSearchEurDrRePatternVO = (PrdSearchEurDrRePatternVO)eurDrList.get(i);
//							
//	
//							PrdPatternVO prdPatternVO2 = new PrdPatternVO();				
//							
//							prdPatternVO2.setObItchgCtnt(prdSearchEurDrRePatternVO.getObContent());
//							prdPatternVO2.setIbItchgCtnt(prdSearchEurDrRePatternVO.getIbContent());
//							prdPatternVO2.setOcnItchgCtnt(prdSearchEurDrRePatternVO.getOcnContent());						
//							
//							createPrdCtlgEurDoor(event,prdSearchEurDrRePatternVO,prdPatternVO2 );
//	
//						}
//						
//					}
//				} catch (Exception ex) {
//					log.error("err " + ex.toString(), ex);
//					try {
//						if((dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
//							log.debug("\n\n PRD log On:");
//							Map map = new HashMap();
//							String userId = ((SignOnUserAccount)event.getAttribute("account")).getUsr_id();
//							map.put("bkgNO", prdCreateParamVO.getBkgNo());
//							map.put("MainPatternPctlNo", prdCreateParamVO.getMainPatternPctlNo());
//							map.put("mapSeq", mapSeq);
//							map.put("usrId", userId);
//							
//							String logDesc =  this.getParamString(map);
//							log.debug("\n\n log::::"+logDesc );
//							
////					dbDao.createPrdExecEnisLog(log_desc,app_info, id);
//							dbDao.createPrdExecEnisLog(logDesc ,"processReplaneFinish_err", userId);
//						}
//					} catch (DAOException e1) {
//						log.error("err " + e1.toString(), e1);
//						throw new EventException(new ErrorHandler(e1).getMessage());
//					}
//					throw new EventException(new ErrorHandler(ex).getMessage());
//				}
				
				
				// pc선택화면의 cost를 위해 pc의 첫번째 것만 cost를 구하고,
				// 선택화면의 변경시 pc 생성때 보여주기 위한 cost를 그때 그때 구한다.(속도 개선)
				// ★ 부패턴은 cop call  은 안함 	
//--------------------------------------------------------------------------------------------------------------------		
				
			}
			

			// EUR TRO 처리 시작
			// 1. EUR TRO 처리가 있는 지 확인한다.
			// 2. ERU TRO 처리가 필요한 PATTERN으로 다시 조사한다.-- 기존 PATTERN 무시
			//    --> 1) POR/DEL NODE와 다른 구주 지역의 S/O나 TRO가 있으면 
			//        2) S/O있으면 S/O 우선 없으면 TRO DATA SEARCH
			// 3. 새로운 형태로 TRO PC를 생성하고 PC NO를 UPDATE 한다.

			event.setAttribute("eur_dr_seq", mapSeq);
				
			try {
				eurDrChk = dbDao.chkEurDr(prdCreateParamVO.getBkgNo()) ;
				
				if(eurDrChk.equals("Y")) {
		            // 새로 변경할 것만 pattern ord 신규로 setting
					dbDao.updatePrdMapReInit(prdCreateParamVO.getBkgNo(),event.getAttribute("eur_dr_seq")+"") ;
					
					// 작업 대상 select
					List<PrdSearchEurDrRePatternVO> eurDrList = dbDao.getEurDr(prdCreateParamVO.getBkgNo(),event.getAttribute("eur_dr_seq")+"") ;	
					
					// pc 생성
					PrdSearchEurDrRePatternVO prdSearchEurDrRePatternVO = null;
					for(int i=0; i<eurDrList.size(); i++){
						
						prdSearchEurDrRePatternVO = (PrdSearchEurDrRePatternVO)eurDrList.get(i);
						

						PrdPatternVO prdPatternVO2 = new PrdPatternVO();				
						
						prdPatternVO2.setObItchgCtnt(prdSearchEurDrRePatternVO.getObContent());
						prdPatternVO2.setIbItchgCtnt(prdSearchEurDrRePatternVO.getIbContent());
						prdPatternVO2.setOcnItchgCtnt(prdSearchEurDrRePatternVO.getOcnContent());						
						
						createPrdCtlgEurDoor(event,prdSearchEurDrRePatternVO,prdPatternVO2 );

						if((dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
							log.debug("\n\n PRD log On:");
							Map map = new HashMap();
							String userId = ((SignOnUserAccount)event.getAttribute("account")).getUsr_id();
							map.put("bkgNO", prdCreateParamVO.getBkgNo());
							map.put("MainPatternPctlNo", prdCreateParamVO.getMainPatternPctlNo());
							map.put("mapSeq", mapSeq);
							map.put("usrId", userId);

							map.put("prdPatternVO2", prdPatternVO2);
							map.put("PrdCreateParamVO", prdCreateParamVO);
							map.put("prdSearchEurDrRePatternVO", prdSearchEurDrRePatternVO);
							
							String logDesc =  this.getParamString(map);
							log.debug("\n\n log::::"+logDesc );
							
							dbDao.createPrdExecEnisLog(logDesc ,"processReplaneFinish_Eur", userId);
						}						
					}
					
				}
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				try {
					if((dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
						log.debug("\n\n PRD log On:");
						Map map = new HashMap();
						String userId = ((SignOnUserAccount)event.getAttribute("account")).getUsr_id();
						map.put("bkgNO", prdCreateParamVO.getBkgNo());
						map.put("MainPatternPctlNo", prdCreateParamVO.getMainPatternPctlNo());
						map.put("PrdCreateParamVO", prdCreateParamVO); 
						map.put("mapSeq", mapSeq);
						map.put("usrId", userId);
						
						String logDesc =  this.getParamString(map);
						log.debug("\n\n log::::"+logDesc );
						
//				dbDao.createPrdExecEnisLog(log_desc,app_info, id);
						dbDao.createPrdExecEnisLog(logDesc ,"processReplaneFinish_err", userId);
					}
				} catch (DAOException e1) {
					log.error("err " + e1.toString(), e1);
					throw new EventException(new ErrorHandler(e1).getMessage());
				}
				throw new EventException(new ErrorHandler(ex).getMessage());
			}
//			// 선택한  주패턴(1)에  pc no로 맵테이블 업데이트.
//			this.updatePrdMapByPcNo(mapSeq,prdCreateParamVO.getBkgNo(),prdCreateParamVO.getMainPatternPctlNo(), "1");
			
		}
//--------------------------------------------------------------------		
		
		return eventResponse;
	}

	/**
     * BKG 에서도 사용
     *
     * @param pctlNo 필수
     * @param prdQtyInfoVO sumQty와 sumTpsz가 없을 경우 필수 아니면 옵션
     * @param sumQty PrdQtyInfoVO 가 없을 경우 필수 아니면 옵션
     * @param sumTpsz PrdQtyInfoVO 가 없을 경우 필수 아니면 옵션
     * @return railCargoAvailRtnTmMap [from = get("RTN_TIME") , to = get("CUT_OFF")]
     * 
     * deprecated SC에서 1st, 2nd, 3rd 첨미사 붙은 메소드를 순서대로 이용하세요
     */
    @Override
    public Map getRailRecevingTime(String pctlNo, PrdQtyInfoVO[] prdQtyInfoVOs, String sumQty, String sumTpsz, String bkgNo) {
     // Qty는 숫자로 더하고, Tpsz는 'D5' 앞자리 한자리 'D'를 문자로 합친다 단, 중복되면 건너뛴다.
      long timeTotal = System.currentTimeMillis();
      DateFormat dateFormat = new SimpleDateFormat( "mm:ss.S");
      Map railCargoAvailRtnTmMap = null;
      Map freeTmMap = null;
      String cutOff = null; // add for debug
      String rtnTime = null; // add for debug
      String ftTotDay = null; // add for debug
      try{
             if(prdQtyInfoVOs != null){
                    double thisSumQty = 0;
                    String thisSumTpsz = "";

                    for(int i = 0; i < prdQtyInfoVOs.length; i++){
                          String tpszSubstring = prdQtyInfoVOs[i].getCTpsz().substring(0, 1);
                          if(!thisSumTpsz.contains(tpszSubstring)){
                                 thisSumTpsz = thisSumTpsz + tpszSubstring ;
                          }
                         thisSumQty += Double.parseDouble(prdQtyInfoVOs[i].getCQty());
                    }

                    sumQty = thisSumQty+"";
                    sumTpsz = thisSumTpsz;
             }
      }catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
//           throw new EventException(new ErrorHandler(ex).getMessage());
    } 
      try{
             PrdProdCtlMstVO mstVo = (PrdProdCtlMstVO) dbDao.getPrdMst(pctlNo).get(0);
             /* *************************************************************
              * getCargoReturnTime 에서 Rail Receive To Date(CUT_OFF)를 산출한 후
              * Rail Receive To date기준으로 DMT에서 계산한 Free day 제하여
              * Rail Receive From date(RTN_TIME)를 계산함.
              * 
              ************************************************************** */
             if("US".equals(mstVo.getPolCd().substring(0, 2))){
            	 /*
            	  * 미주도 CANADA처럼 처리 하고 없으면 기존 로직 20130930
            	  */
            	 String holyday="0";
            	 //holyday = dbDao.getCanadaCargoReturnTimeIncludeHolyday(pctlNo);  // 1/1, 12/25을 제외하는 로직 제외 (by 이경한 차장, 2017-11-09)
            	 railCargoAvailRtnTmMap = dbDao.getCanadaCargoReturnTime(pctlNo, holyday, bkgNo);
            	 cutOff = (String)railCargoAvailRtnTmMap.get("CUT_OFF"); // for debug
            	 rtnTime = (String)railCargoAvailRtnTmMap.get("RTN_TIME"); // for debug
            	 // CANADA 방식으로 데이터가 없으면 기존 방식으로 사용
            	 if (rtnTime == null || "".equals(rtnTime)) { 
            		 
            		 railCargoAvailRtnTmMap = dbDao.getCargoReturnTime(pctlNo);
            		 if(railCargoAvailRtnTmMap !=null){
	            			 
	            		 cutOff = (String)railCargoAvailRtnTmMap.get("CUT_OFF"); // for debug
	//	             rtnTime = (String)railCargoAvailRtnTmMap.get("RTN_TIME"); // for debug
	            		 rtnTime = (String)railCargoAvailRtnTmMap.get("ERD"); // for debug
	            		 //             mstVo.setN1stVslLodgDueDt((String)railCargoAvailRtnTmMap.get("CUT_OFF"));
	            		 mstVo.setN1stVslLodgDueDt(cutOff);
	            		 freeTmMap = dbDao.getFreeTime(mstVo, sumQty, sumTpsz );
	            		 ftTotDay = (String)freeTmMap.get("o_ft_total_day");
	            		 /* 
	            		  * CHM-201111865 PRD 생성 시 기반 데이터(패러미터 값) 오류 확인 및 수정 요청
	            		  * railCargoAvailRtnTmMap의 값이 없을 경우 Outbound에 Rail이 없을 경우이다.
	            		  * PC내에서 US Rail이 없는 경우이므로, Skip한다.
	            		  */
	            		 if (rtnTime == null || "".equals(rtnTime)) {
	            			 railCargoAvailRtnTmMap.put("RTN_TIME", "");
	            			 railCargoAvailRtnTmMap.put("CUT_OFF", "");
	            		 } else {
	//	            	 railCargoAvailRtnTmMap.put("RTN_TIME",DateTime.addDays((String)railCargoAvailRtnTmMap.get("RTN_TIME"), Integer.parseInt((String)freeTmMap.get("o_ft_total_day"))*-1, "yyyyMMdd"));
	            			 railCargoAvailRtnTmMap.put("RTN_TIME",rtnTime);
	            		 }
            		 }
            	 }
            	 //------------------------------------------------
            	 
            	 
             } else if("CA".equals(mstVo.getPolCd().substring(0, 2))){
            	 String holyday="0";
            	 //holyday = dbDao.getCanadaCargoReturnTimeIncludeHolyday(pctlNo); //1/1, 12/25을 제외하는 로직 제외 (by 이경한 차장, 2017-11-09)
            	 railCargoAvailRtnTmMap = dbDao.getCanadaCargoReturnTime(pctlNo, holyday, bkgNo);
            	 if(railCargoAvailRtnTmMap!=null){
	            	 cutOff = (String)railCargoAvailRtnTmMap.get("CUT_OFF"); // for debug
	            	 rtnTime = (String)railCargoAvailRtnTmMap.get("RTN_TIME"); // for debug
	            	 if (rtnTime == null || "".equals(rtnTime)) {
	            		 railCargoAvailRtnTmMap.put("RTN_TIME", "");
	            		 railCargoAvailRtnTmMap.put("CUT_OFF", "");
	            	 }
            	 }
             }
             
             String from ="";
             if(railCargoAvailRtnTmMap!=null){
            	 from = (String)railCargoAvailRtnTmMap.get("RTN_TIME");
            	 
             }
             String to ="";
             if(railCargoAvailRtnTmMap!=null){
            	 to = (String)railCargoAvailRtnTmMap.get("CUT_OFF");
            	 
             }
           log.debug("\n-------------------------------------" +
                        "\n getCargoReturnTime" +
                        "\n RTN_TIME:"+from+
                        "\n CUT_OFF:"+to +
                        "\n-------------------------------------" );
             
      }catch (DAOException e1) {
             log.error("err " + e1.toString(), e1);
             log.error(" ************************************************************ ");
             log.error(" ************* RAIL RECEIVING ERROR WITH DAO **************** ");
             log.error(" ************************************************************ ");
             log.error("pctlNo[" + pctlNo + "],  CUT_OFF[" + cutOff + "],  RTN_TIME[" + rtnTime + "],  o_ft_total_day[" + ftTotDay + "]");
             log.error(" ************************************************************ ");
             log.error(" ************************************************************ ");
      } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             log.error(" ************************************************************ ");
             log.error(" ************* RAIL RECEIVING ERROR COMMON ****************** ");
             log.error(" ************************************************************ ");
             log.error("pctlNo[" + pctlNo + "],  CUT_OFF[" + cutOff + "],  RTN_TIME[" + rtnTime + "],  o_ft_total_day[" + ftTotDay + "]");
             log.error(" ************************************************************ ");
             log.error(" ************************************************************ ");
             railCargoAvailRtnTmMap = new HashMap();
             railCargoAvailRtnTmMap.put("RTN_TIME", "");
             railCargoAvailRtnTmMap.put("CUT_OFF", "");
             log.error("ClassCastException 해결할 때 까지만 catch 합니다. ", ex);
             
      }

      log.info("\n------------------------------------------------------------------------------" +
                  "\n  RailRecevingTime: "+dateFormat.format(new Date(System.currentTimeMillis()-timeTotal)) +
                  "\n------------------------------------------------------------------------------");
      return railCargoAvailRtnTmMap;
    }



	/**
	 * @param e
	 * @return int
	 * @throws EventException
	 */
	public int updateMainMapSeq(Event e) throws EventException {
		// TODO Auto-generated method stub
		EsdPrd0080Event event = (EsdPrd0080Event)e;
 		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
 		SignOnUserAccount account = (SignOnUserAccount)e.getAttribute("account"); 
 		/*
		 * SC 의 createPrdCtlgFullRout 는 선택화면을 위한 메소드
		 * PC를 생성하고, 선택화면에 필요한 데이터를 위해 조회를 한다.
		 */		
 		//replane 시  맵테이블을 만든 map sequence를 받는다.
		String mapSeq = prdCreateParamVO.getMapSeq();
		log.debug("\n\n replane 주패턴 처리-----------------------------------" +
				"\n processReplaneFinish ------------------------------------ "+
	             "\n mapSeq : "+mapSeq);
		// 선택한  주패턴(1)에  pc no로 맵테이블 업데이트.
		int successCnt = this.updatePrdMapByPcNo(mapSeq,prdCreateParamVO.getBkgNo(),prdCreateParamVO.getMainPatternPctlNo(), "1");
		try {
			if((successCnt == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
				log.debug("\n\n PRD log On:");
				Map map = new HashMap();
				
				map.put("bkgNO", prdCreateParamVO.getBkgNo());
				map.put("MainPatternPctlNo", prdCreateParamVO.getMainPatternPctlNo());
				map.put("mapSeq", mapSeq);
				map.put("usrId", account.getUsr_id());
				
				String logDesc = "successFlag " + Integer.toString(successCnt) + " " + this.getParamString(map);
				log.debug("\n\n log::::"+logDesc );
				
				dbDao.createPrdExecEnisLog(logDesc ,"updateMainMapSeq", account.getUsr_id());
			}
		} catch (DAOException e1) {
//			e1.printStackTrace();
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}		
		return successCnt;
	}

	/**
	 * @param String bkgNo - Booking 번호
	 * @param PrdQuantityVO[] prdQuantityVOs - 화면에서 제공되는 Booking Quantity 정보를 Parameter로 받는다.
	 * @return String - 화면 또는 DB에 있는 Booking Quantity 정보와 SO Quantity정보를 Merge한 것을 한줄의 String 형식으로 반환한다.
	 * @throws EventException
     * ----------------------------------------------------------------------
     * HISTORY
     * 2010.09.17 박만건 [CHM-201005548] [SCEM / PRD] F.H. 기능 연계한 개발요청 (Method 추가)
	 */
	public String getReplanCntrTpszQty(String bkgNo ,PrdQuantityVO[] prdQuantityVOs) throws EventException {
		
		StringBuffer cntrTpszQtyTblStr= new StringBuffer();
		
		try {
			ArrayList alConType = new ArrayList();  // Container Type
			ArrayList alConQty = new ArrayList();   // Container Quantity
			
			// 1. prdQuantityVO값이 없을 경우 Bkg_quantity정보를 이용하여 Container Quantity기본 정보를 준비한다. Park Mangeon
			if (prdQuantityVOs.length == 0){
				DBRowSet dbR = dbDao.checkBkgQty(bkgNo);

				while(dbR.next()){
					alConQty.add(dbR.getString("C_TPSZ"));
					alConType.add(dbR.getString("C_QTY"));
				}
			} else {
				for(int t=0; t<prdQuantityVOs.length; t++){
					alConQty.add(prdQuantityVOs[t].getCQty());
					alConType.add(prdQuantityVOs[t].getCTpsz());
				}
			}

			// 3. D4@2@BKG,D5@1@SO 형식으로 데이터 만들기 
			for(int j = 0;j < (alConType.isEmpty()?0:alConType.size()); j++) {
				cntrTpszQtyTblStr.append(((j == 0) ? "" : ",") + alConType.get(j)+"@"+alConQty.get(j));
			}
			// cntrTpszQtyTblStr 값이 없을때 처리 로직 
			if(cntrTpszQtyTblStr.toString().equals("")){
				cntrTpszQtyTblStr.append("''");
			}

			log.debug("\n D4@2@BKG,D5@1@SO 형식으로 데이터 만들기: " + cntrTpszQtyTblStr.toString());
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return cntrTpszQtyTblStr.toString();
	}
	
	
	/**
	 * @param String pctlNo
	 * @return List<PrdConstraintInfoVO>
	 * @throws EventException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoNode(String pctlNo) throws EventException {
		try {
			return dbDao.searchPrdCnstInfoNode(pctlNo);
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
	}

	/**
	 * @param String pctlNo
	 * @return List<PrdConstraintInfoVO>
	 * @throws EventException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoLink(String pctlNo) throws EventException {
		try {
			return dbDao.searchPrdCnstInfoLink(pctlNo);
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
	}
	
	/**
	 * @param String pctlNo
	 * @return List<PrdConstraintInfoVO>
	 * @throws EventException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoRoute(String pctlNo) throws EventException {
		try {
			return dbDao.searchPrdCnstInfoRoute(pctlNo);
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
	}
	
	/**
	 * searchPrdCnstInfoIrgPolPod
	 * 
	 * @param PrdSearchParamVO prdSearchParamVO
	 * @return List<PrdConstraintInfoVO>
	 * @throws EventException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoIrgPolPod(PrdSearchParamVO prdSearchParamVO) throws EventException {
		try {
			return dbDao.searchPrdCnstInfoIrgPolPod(prdSearchParamVO);
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		}
	}

	
	/**
	 * Hinterland관련한 PC를 생성한다.
	 * - Inland(Hinterland)의 PC는 H로 시작한다.
	 * - Feeder의 PC는 F로 시작한다.
	 * @param PrdHinterlandInfoVO hinterlandInfoVo
	 * @return PrdHinterlandInfoVO
	 */
	public PrdHinterlandInfoVO createPrdCtlgHinterland(PrdHinterlandInfoVO hinterlandInfoVo){
		PrdHinterlandInfoVO rtnVo = new PrdHinterlandInfoVO();
		PrdCreateManageBCImpl prdCreateManageBC = new PrdCreateManageBCImpl();
		String hdPctlNo = "";
		try{
			
			/* ***************************************************************************** */
			/* ************************** Parameter 검사 ************************************ */
			/* ***************************************************************************** */
			if (hinterlandInfoVo == null) {
				rtnVo.setErrCd("P02");
				rtnVo.setErrDesc("PLZ Contact COL-TN");
				return rtnVo;
			}
			if (hinterlandInfoVo.getPctlIoBndCd() == null 
					|| !(hinterlandInfoVo.getPctlIoBndCd().equals("I") 
					|| hinterlandInfoVo.getPctlIoBndCd().equals("O") 
					|| hinterlandInfoVo.getPctlIoBndCd().equals("T")) ) {
				rtnVo.setErrCd("P03");
				rtnVo.setErrDesc("PLZ Contact COL-TN" );
				return rtnVo;
			}
			
			int chkLen = hinterlandInfoVo.getPctlIoBndCd().equals("T")?5:7;

			if (hinterlandInfoVo.getFmNodCd() == null || !(hinterlandInfoVo.getFmNodCd().length() >= chkLen)) {
				rtnVo.setErrCd("P04");
				rtnVo.setErrDesc("PLZ Contact COL-TN" );
				return rtnVo;
			}
			if (hinterlandInfoVo.getToNodCd() == null || !(hinterlandInfoVo.getToNodCd().length() >= chkLen)) {
				rtnVo.setErrCd("P04");
				rtnVo.setErrDesc("PLZ Contact COL-TN" );
				return rtnVo;
			}
			
			/* ***************************************************************************** */
			/* ******************* Inland Route, Feeder Link 검사 *************************** */
			/* ***************************************************************************** */
			PrdHinterlandInfoVO infoVo = dbDaoHLand.searchHinterlandInfo(hinterlandInfoVo.getPctlIoBndCd(), hinterlandInfoVo.getFmNodCd(), hinterlandInfoVo.getToNodCd());
			if(!"".equals(JSPUtil.getNull(infoVo.getErrCd())) && !"P00".equals(JSPUtil.getNull(infoVo.getErrCd()))) {
				rtnVo.setErrCd(JSPUtil.getNull(infoVo.getErrCd()));
				rtnVo.setErrDesc(JSPUtil.getNull(infoVo.getErrDesc()));
				
				// Code가 반영되기전 임시사용
				if("P99".equals(JSPUtil.getNull(infoVo.getErrCd()))) {
					rtnVo.setErrDesc("PLZ Contact COL-TN");
				} else if("P01".equals(JSPUtil.getNull(infoVo.getErrCd()))) {
					rtnVo.setErrDesc("Invalid Node ( " + JSPUtil.getNull(infoVo.getErrDesc()) + " )");
				} else if("P32".equals(JSPUtil.getNull(infoVo.getErrCd()))) {
					rtnVo.setErrDesc("MTY RTN YD Not Avalidable ( " + JSPUtil.getNull(infoVo.getErrDesc()) + " )");
				} else if("P33".equals(JSPUtil.getNull(infoVo.getErrCd()))) {
					rtnVo.setErrDesc("MTY PU YD Not Avaliable ( " + JSPUtil.getNull(infoVo.getErrDesc()) + " )");
				} else if("P36".equals(JSPUtil.getNull(infoVo.getErrCd()))) {
					rtnVo.setErrDesc("Zone Code or its Rep. CY Not Available ( " + JSPUtil.getNull(infoVo.getErrDesc()) + " )");
				} else if("P37".equals(JSPUtil.getNull(infoVo.getErrCd()))) {
					rtnVo.setErrDesc("Bound-Trans Mode Mapping Error ( " + JSPUtil.getNull(infoVo.getErrDesc()) + " )");
				} else if("P62".equals(JSPUtil.getNull(infoVo.getErrCd()))) {
					rtnVo.setErrDesc("Calling TMNL Not Avaliable ( " + JSPUtil.getNull(infoVo.getErrDesc()) + " )");
				}
				return rtnVo;
			}
			
			/* ***************************************************************************** */
			/* ************************** Parameter 세팅 ************************************ */
			/* ***************************************************************************** */
			PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
			
			String srTerm = "";
			String sdTerm = "";
			String cct = "";
			String pmF = "";
			String podT = "";
			String polT = "";
			String spmFlg = "";
			String srfCntr = "";
			String smtPu = "";
			String smtRtn = "";
			String sinclShtlSoFlg =  "";
			String subRout = "";
			String fullCy = "";
			String trspModCd = "";
			String stermNode = "";
			String prdCtlNo = "";
			String ioBndCd = hinterlandInfoVo.getPctlIoBndCd();
			String fromNode = hinterlandInfoVo.getFmNodCd();
			String toNode = hinterlandInfoVo.getToNodCd();
			String creUsrId = hinterlandInfoVo.getCreUsrId();
			
			if ("T".equals(ioBndCd)) {
				hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(PrdConstants.PRD_PC_MOD_HINTER_FDR);
			} else {
				hdPctlNo = prdCreateManageBc.createPrdCtlNoGen(PrdConstants.PRD_PC_MOD_HINTERLAND);
			}
			
			if (null == creUsrId || "".equals(creUsrId)) {
				creUsrId = "SYSTEM";
			}
			
			// bound code에 따라 값 setting
			if ("O".equals(ioBndCd)) {
				// fromNode 의 유형에 따라 D, Y중 선택한다.
				srTerm = infoVo.getTermCd();
				sdTerm = "Y";
				cct = infoVo.getRunTm();
				polT = infoVo.getRunTm();
				prdCtlNo = infoVo.getPctlNo();
				if("Y".equals(infoVo.getTermCd())) {
					smtPu = fromNode;	
				}
			} else if ("I".equals(ioBndCd)) {
				// fromNode 의 유형에 따라 D, Y중 선택한다.
				srTerm = "Y";
				sdTerm = infoVo.getTermCd();
				podT = infoVo.getRunTm();
				prdCtlNo = infoVo.getPctlNo();
				if("Y".equals(infoVo.getTermCd())) {
					smtRtn = toNode;
				}
			} 
				
			/* ***************************************************************************** */
			/* *********************** Product Catalog 생성 ********************************* */
			/* ***************************************************************************** */
			int successCnt = 0;
			if ("T".equals(ioBndCd)) {
				// 별도 SQL을 돌린다. (fromNode, toNode, creUsrId)
				successCnt =dbDaoHLand.createFeederCatalog(hdPctlNo, fromNode, toNode, creUsrId);
			} else {
				successCnt =dbDaoTro.troAutoChange(ioBndCd, srTerm, sdTerm, creUsrId, hdPctlNo, cct, pmF, podT, polT, spmFlg, srfCntr, smtPu, smtRtn, fromNode, toNode, sinclShtlSoFlg, subRout, fullCy, trspModCd, stermNode, prdCtlNo);
//				dbDaoHLand.removeHinterlandEmptyYard(hdPctlNo, srTerm, sdTerm);

				// 0001로 생성된 것 PC를 0002로 복제한다.
				dbDaoHLand.copyPrdCatalogMaster(hdPctlNo, "0002");
				dbDaoHLand.copyPrdCatalogRouteDetail(hdPctlNo, "0002");
				dbDaoHLand.copyPrdCatalogMaster(hdPctlNo, "0003");
				dbDaoHLand.copyPrdCatalogRouteDetail(hdPctlNo, "0003");
			}
			
			if ( successCnt > 0){
				/* ***************************************************************************** */
				/* ************ Quantity 생성 (0001, 0003 = 20f, 0002, 0004 = 40f)*************** */
				/* ***************************************************************************** */
				dbDaoHLand.createContainerQty(hdPctlNo, creUsrId);
	
				/* ***************************************************************************** */
				/* ************************ Activity Group Detail 생성 ************************** */
				/* ***************************************************************************** */
				PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
				prdPcCreateVo.setHdPctlNo(hdPctlNo);
				prdPcCreateVo.setObTroFlg("N");
				prdPcCreateVo.setIbTroFlg("N");
				PrdPatternVO prdPatternVO = new PrdPatternVO();
				prdPatternVO.setObItchgCtnt("");
				prdPatternVO.setOcnItchgCtnt("");
				prdPatternVO.setIbItchgCtnt("");
				prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo,prdPatternVO,creUsrId );
				if ("T".equals(ioBndCd)) {
					// FEEDER 앞뒤 NODE를 제외하고 삭제
					dbDaoHLand.removeNonFeederActivity(hdPctlNo);
				}
				log.debug("\n step 1");
				if (!"T".equals(ioBndCd)) {
					String costActChk = dbDaoHLand.checkInlandCostActivity(hdPctlNo);
					if (!"N".equals(costActChk)) {
						rtnVo.setErrCd("P71");
						rtnVo.setErrDesc("PLZ Contact COL-TN (" + costActChk + ")");
						return rtnVo;
					}
				}
				log.debug("\n step 2");
				/* ***************************************************************************** */
				/* ************************ Master table USLGB NULL처리 ************************** */
				/* ***************************************************************************** */
				
				dbDaoHLand.updatePrdMst(hdPctlNo);
				log.debug("\n step 3");
				
				/* ***************************************************************************** */
				/* ************************** Return Parameter 세팅 ***************************** */
				/* ***************************************************************************** */
				rtnVo.setHdPctlNo(hdPctlNo);
				DBRowSet dbR = prdCreateManageBC.selectPcNoMinMax(hdPctlNo);
				String maxPctlNo = "";
				if(dbR.next()){
					maxPctlNo = dbR.getString("max_pc");
				}
				log.debug("\n step 4");
				
				rtnVo.setD2PctlNo(hdPctlNo + "0001"); // 성공시 항상 20f
				rtnVo.setD4PctlNo(hdPctlNo + "0002"); // 성공시 항상 40f
				rtnVo.setD7PctlNo(hdPctlNo + "0003"); // 성공시 항상 45f
				
				if(maxPctlNo.equals(hdPctlNo + "0006")) {
					rtnVo.setD2PstPctlNo(hdPctlNo + "0004"); // Feeder의 Post 20f (Dry)
					rtnVo.setD4PstPctlNo(hdPctlNo + "0005"); // Feeder의 Post 40f (Dry)
					rtnVo.setD7PstPctlNo(hdPctlNo + "0006"); // Feeder의 Post 45f (Dry)
				}
				
				//RF PC는 Ocean feeder 일때만 
				if ("T".equals(ioBndCd)) {
					//rf 의  pre,post 용 copy (0003,0004/0005,0006,0007,0008)
					dbDaoHLand.copyRfPrdCatalogMaster(hdPctlNo, maxPctlNo);
					dbDaoHLand.copyRfPrdCatalogRouteDetail(hdPctlNo, maxPctlNo);
					dbDaoHLand.copyRfContainerQty(hdPctlNo, maxPctlNo);
					dbDaoHLand.copyRfActivityGroup(hdPctlNo, maxPctlNo);
				}
				log.debug("\n step 5");
				
				//max 가 0004 이면 Fdr 이므로 RF도 만들어짐.
				if(maxPctlNo.equals(hdPctlNo + "0006")) {
					rtnVo.setR2PctlNo(hdPctlNo + "0007");
					rtnVo.setR5PctlNo(hdPctlNo + "0008");
					rtnVo.setR7PctlNo(hdPctlNo + "0009");
					rtnVo.setR2PstPctlNo(hdPctlNo + "0010"); // Feeder의 rf Post 20f
					rtnVo.setR5PstPctlNo(hdPctlNo + "0011"); // Feeder의 rf Post 50f
					rtnVo.setR7PstPctlNo(hdPctlNo + "0012"); // Feeder의 rf Post 45f
				} else if("T".equals(ioBndCd)){
					rtnVo.setR2PctlNo(hdPctlNo + "0004");  // rf 의 20 ft/
					rtnVo.setR5PctlNo(hdPctlNo + "0005");  // rf 의 50 ft/
					rtnVo.setR7PctlNo(hdPctlNo + "0006");  // rf 의 45 ft/
				}
				log.debug("\n step 6");
				
			} else {
				rtnVo.setHdPctlNo(hdPctlNo);
				// 에러 사유를 담는다.
				rtnVo.setErrCd("P98");
				rtnVo.setErrDesc("PLZ Contact COL-TN");
			}
		}catch (DAOException e1) {
			rtnVo.setHdPctlNo(hdPctlNo);
			// 에러 사유를 담는다.
			rtnVo.setErrCd("P81");
			rtnVo.setErrDesc("PLZ Contact COL-TN");				

			log.error("err " + e1.toString(), e1);
//			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			rtnVo.setHdPctlNo(hdPctlNo);
			// 에러 사유를 담는다.
			rtnVo.setErrCd("P82");
			rtnVo.setErrDesc("PLZ Contact COL-TN");				
			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return rtnVo;
	}

	

	/**
	 * @param String pctlNo
	 * @return String  
	 * @throws DAOException
	 */
	public String searchPrdCnstInfoCanadaException(String pctlNo)
			throws EventException {
		String retunCnst = "N";
			try {
				if(dbDao.getPrdLogOnOff("ESD_PRD_CAD7").equalsIgnoreCase("Y")) {
					
					retunCnst= dbDao.searchPrdCnstInfoCanadaException(pctlNo);
				}
			} catch (DAOException e1) {
				log.error("err " + e1.toString(), e1);
				throw new EventException(new ErrorHandler(e1).getMessage());
			}
			return retunCnst;
	}
	
	/**
	 * Pre CM 화면에서 Pc 생성을 위해 호출하는 메소드 
	 * long transaction 을 위해 backEndJob 처리 
	 * @param SignOnUserAccount account
	 * @param EsdPrd0080Event event
	 * @return String
	 * @throws EventException
	 */
	public String startPrdBackEndJob(SignOnUserAccount account, EsdPrd0080Event event) throws EventException{
		ProductCatalogCreateBackEndJob backEndJob = new ProductCatalogCreateBackEndJob();
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		String key = "";
		try{
			backEndJob.setEvent(event);
			backEndJob.setSignOnUserAccount(account);
			key = backEndJobManager.execute(backEndJob, account.getUsr_id(), "Prd Search.");
			log.debug("\n\n --------------------------\n startPrdBackEndJob key"+ key);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRD99998", new String[]{"\n PRD startPrdBackEndJob Check. \n"}).getMessage());
		}
		return key;
	}

	/**
	 * ERD 위해 호출하는 메소드 
	 * @param GeneralEventResponse eventResponse
	 * @param EsdPrd0080Event event
	 * @throws EventException
	 */
	public void getERD(GeneralEventResponse eventResponse, EsdPrd0080Event event)
			throws EventException {
//		DBRowSet dbRowsetEmpty = null;
		DBRowSet dbRowsetPortCct = null;
//		PrdPcCreateVO prdPcCreateVO = (PrdPcCreateVO)event.getPrdPcCreateVO();
		PrdCreateParamVO prdCreateParamVO = (PrdCreateParamVO)event.getPrdCreateParamVO();
		String from = "";
		String to = "";
		String viewPctlNo = "";
//		viewPctlNo = prdPcCreateVO.getHdPctlNo();
		viewPctlNo = (String)event.getAttribute("search_pctl_no");
		if (prdCreateParamVO.getPor().substring(0, 2).equals("US") || prdCreateParamVO.getPor().substring(0, 2).equals("CA") ){
			//---free time CALL(미주일때만)--------------------------------------------------------------------------------------
			Map map = this.getRailRecevingTime(viewPctlNo, null, prdCreateParamVO.getSumBkgQty(), prdCreateParamVO.getSumCTpSz(), prdCreateParamVO.getBkgNo());

//			from = map.get("RTN_TIME") == null ? "receveTime is null" : (String)map.get("RTN_TIME");
//			to =   map.get("CUT_OFF") == null ? "receveTime is null" : (String)map.get("CUT_OFF");
			from = map.get("RTN_TIME") == null ? "" : (String)map.get("RTN_TIME");
			to =   map.get("CUT_OFF") == null ? "" : (String)map.get("CUT_OFF");
		}
		eventResponse.setETCData("RAIL_ERD", from);
		eventResponse.setETCData("RAIL_LRD", to);

		try {
			dbRowsetPortCct = dbDao.searchPortCct(viewPctlNo);
			
//			String port = "";
			String cct = "";
			if(dbRowsetPortCct.next()){
//				String cutOffFlag = "";
//				if("Y".equals(dbRowsetPortCct.getString("rf_spcl_flg")) ){
//					cutOffFlag = "RF-";
//				}else if("Y".equals(dbRowsetPortCct.getString("dg_spcl_flg")) ){
//					cutOffFlag = "DG-";
//				}
//				port = dbRowsetPortCct.getString("port");
				cct = dbRowsetPortCct.getString("cct");
				eventResponse.setETCData("PORT_CCT", cct);
				eventResponse.setETCData("INIT_ETA", dbRowsetPortCct.getString("INIT_ETA_DT"));
				eventResponse.setETCData("VPS_ETA", dbRowsetPortCct.getString("VPS_ETA_DT"));
				eventResponse.setETCData("ERD", dbRowsetPortCct.getString("ERD"));
				
			}
			
			
		} catch (DAOException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(new ErrorHandler(e1).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PC생성 로직  
	 * BKG의 pc생성로직과 BKG에서 PC가 1개이상 생겨 화면용PC를 만들기 위해 호출.
	 * 즉,BKG 에서 PC생성을 위해 호출시 모두 사용.  
	 * 1.bkg에서 method call시에도 사용.
	 * 2.url 호출시도 사용. 
	 * 
	 * 3.prd inquery 에서도 호출 
	 * @param e
	 * @throws EventException
	 */
	public void createPrdCtlgFullRoutWeb(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		PrdCreateParamVO prdCreateParamVO = event.getPrdCreateParamVO();
		SignOnUserAccount account = (SignOnUserAccount)e.getAttribute("account"); 
//		PrdPatternVO prdPatternVO = null;
		int successFlag = 0;
		// pc no 생성 
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		String hdPctlNo = prdCreateManageBc.createPrdCtlNoGen( prdCreateParamVO.getPcMode());
		
		// pc return value object create
		PrdPcCreateVO prdPcCreateVo = new PrdPcCreateVO();
		// pc_no_head set		
		prdPcCreateVo.setHdPctlNo(hdPctlNo);
		prdPcCreateVo.setIdaHlgTpCd(prdCreateParamVO.getIdaHlgTpCd());
		
		String skdType = prdCreateParamVO.getInternalSkdType();
		
		if(!"L".equals(skdType)){
		//skdType(L,V) 찾음.
			skdType = prdCreateManageBc.getSkdType( prdCreateParamVO.getTVvd(),prdCreateParamVO.getLdDt(), prdCreateParamVO.getPol1());
		}
		//skdType(L,V) 셋팅, skdDate 셋팅.
		prdPcCreateVo.setSkdType(skdType);

		log.debug("\n\n ========= "+ prdPcCreateVo.getSkdType());
		//skdDate 셋팅. (date, vvd)
		if(skdType.equals("L") ){
			if(prdCreateParamVO.getInternalSkdType()!= null &&  !prdCreateParamVO.getInternalSkdType().equals("")
					&& prdCreateParamVO.getLdDt().equals("")){
 				prdCreateParamVO.setLdDt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
			}
			// skd function 에서 skd_date를 date 또는 vvd를 사용하므로 셋팅해준다.
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getLdDt());
		}else {
			// skd function 에서 skd_date를 date 또는 vvd를 사용하므로 셋팅해준다.
			prdPcCreateVo.setSkdDate(prdCreateParamVO.getTVvd());
		}
		
		event.setPrdPcCreateVO(prdPcCreateVo);

		try {
//			// prd mst,dtl 생성


				successFlag = dbDao.createProductCatalogIncludeReplane(prdCreateParamVO, prdPcCreateVo, null, account.getUsr_id() );
				if((successFlag == 0 && dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("Y")) || dbDao.getPrdLogOnOff("ESD_PRD_LOG").equalsIgnoreCase("S")){
					log.debug("\n\n PRD log On:");
					Map map = new HashMap();
					
					map.put("PrdCreateParamVO", prdCreateParamVO);
					map.put("PrdPcCreateVO", prdPcCreateVo);
//					map.put("PrdPatternVO", prdPatternVO);
					map.put("hdPctlNo", hdPctlNo);
					map.put("usrId", account.getUsr_id());
					
					String logDesc = "successFlag " + Integer.toString(successFlag) + " " + this.getParamString(map);
					log.debug("\n\n log::::"+logDesc );
					dbDao.createPrdExecEnisLog(logDesc ,"createPrdCtlgFullRout", account.getUsr_id());
				}
				
				// PC 화면에서 호출시 MT PU DATE 체크 
				// N개의 PC생성시 MT PU DATE가 맞지 않으면 제외 하고, 나머지는 입력된 MT PU DATE로 업데이트 
				// MT PU DATE 가 입력되었을때 입력값이  SKD보다 뒤이면  EXCEPTION 
				// 입력값이 SKD DATE보다 앞이면 입력값으로 SKD을 변경.
				//1.MST PC갯수 확인 
				//2.해당 갯수 만큼 LOOP 돌면서 체크
//				log.debug("\n getRcvT():["+prdCreateParamVO.getRcvT() +"], getMtPkupDt():["+prdCreateParamVO.getMtPkupDt()+"]");				
//				log.debug("\n\n  %%%%%%%  prdCreateParamVO.getMtPkupDt(): "+prdCreateParamVO.getMtPkupDt());
//				if( !prdCreateParamVO.getRcvT().equals("S") &&  prdCreateParamVO.getMtPkupDt()!= null 
//						&& !prdCreateParamVO.getMtPkupDt().equals("") ){
//					List prdMstList = dbDao.selectPrdMstByHdPctlNO(hdPctlNo);
//					int prdMstCnt = prdMstList.size();
//					log.debug("\n\n  %%%%%%%  prdMstCnt: "+prdMstCnt);
//					
//					int i= 0;
//					int deleteCnt =0;
//					// pc가 2개 이상일때만 (prdMstCnt>1)
//					// pc가 1개 일때도 처리 하게 (20100125)
//					while (prdMstCnt>=1 && i < prdMstCnt){
//						PrdProdCtlMstVO prdProdCtlMstVO  = (PrdProdCtlMstVO)prdMstList.get(i);
//						log.debug("\n\n  %%%%%%%  getPctlNo: "+prdProdCtlMstVO.getPctlNo());
//						if( !checkMtPkupDt( prdProdCtlMstVO.getPctlNo(),prdCreateParamVO.getMtPkupDt()) ) {
////							throw new EventException(" Mt PkUp Date invalid!");
//							//dtl delete 
//							int successsFlgMt = dbDao.updatePrdDtlByMtPuDtValidate( prdProdCtlMstVO.getPctlNo() ,prdCreateParamVO.getMtPkupDt() );
//							log.debug("\n\n updatePrdDtlByMtPuDtValidate  successFlag: "+successsFlgMt);
// 							// pc mode를 X로 업데이트 
//							successsFlgMt = dbDao.updatePrdMstByMtPuDtValidate( prdProdCtlMstVO.getPctlNo() );
//							log.debug("\n\n updatePrdMstByMtPuDtValidate  successFlag: "+successsFlgMt);
//							deleteCnt ++;
//
//						} else {
//							// mt dt 를 변경해준다. 
//							setMtPkupDt(prdProdCtlMstVO.getPctlNo(), prdCreateParamVO.getMtPkupDt());						
//						}
//						i++;
//					}	
//					log.debug("\n\n\n pc생성개수와 delete된 개수가 같으면 exception 발생.-------------" +
//							"\n prdMstCnt:"+prdMstCnt+
//							"\n deleteCnt:"+deleteCnt+
//							"\n-------------------------------------------------------------------\n\n");
//					//pc생성개수와 delete된 개수가 같으면 exception 발생.
//					if(prdMstCnt>=1 &&  prdMstCnt==deleteCnt){
////						throw new EventException(new ErrorHandler(" Mt PkUp Date invalid!").getMessage());
//						throw new EventException(new ErrorHandler("PRD00058").getMessage());
//					}
//				}	
				

		
			//PC생성시 에러는 없고 PC가 만들어지지 않았을때
			if(successFlag <= 0){
//				event.setAttribute("prdPatternVO", prdPatternVO);
				
				//pc create fail 메세지를 SC에서 확인해서 VERIFY CHECK 를 해서 메세지를 보여준다.
				throw new EventException( (new ErrorHandler("PRD00074")).getMessage() );
			}

//			// Auto IRG를 생성해야하는지 검사하고, 필요시 생성한다. 20100713
//			prdCreateManageBc.createAutoIRG(prdPcCreateVo.getHdPctlNo(), account.getUsr_id(), account.getOfc_cd());
			
//			
//			// qty 생성
			prdCreateManageBc.createContainerQty(e);
//			
//			// data 정리 (min, max pc no )
			prdCreateManageBc.dataArrangement(e);
//			
			log.debug("\n\n -------------dataArrangement 종료----------------------");
			
//			// activity group dtl 생성
//			prdCreateManageBc.createActivityGroup(e);
			prdCreateManageBc.createActivityGroupIncludePattern(prdPcCreateVo, null,account.getUsr_id() );
			
			
			log.debug("\n\n -------------createActivityGroup 종료----------------------");
//			
//			// activity group dtl update
			prdCreateManageBc.updateActivityGroup(hdPctlNo);
			
			log.debug("\n\n -------------createActivityGroup 종료----------------------");
			

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

}
		