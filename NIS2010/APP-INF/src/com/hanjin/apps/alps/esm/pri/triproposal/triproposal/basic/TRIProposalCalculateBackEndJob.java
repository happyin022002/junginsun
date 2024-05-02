/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalCalculateBackEndJob.java
*@FileTitle : CM Summary List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.21 송민석
* 1.0 Creation
 * 2010.10.01 송호진 COA 상의 OPMS 결함 복구작업 [메소드명 변경] createCoaCostPkgPreCMAbc => createCoaCostPkgPreCMAbcStp
 * 2012.07.12 송호진 CHM-201218988 : PRS ROUTE CASE 비용 산출 배치 작업 요청(7월) 건에 의해 발견된 부분 수정 
                                       신규로 추가된 2 개의 필드 (MtyPkupYdCd,MtyPkupYdCdNode ) 를 Blank 로 세팅하여 COA Method ( Procedure ) 를 호출 하도록 해야 함
 * 2012.07.17 송호진 CHM-201218988 : PRS ROUTE CASE 비용 산출 배치 작업 요청(7월) 건에 의해 발견된 부분 수정 두번째 
				    Cost 계산에서 사용되는 COA 의 데이터들을 지우는 로직을 추가                                                                  
 * 2012.07.18 송호진 CHM-201218988 : PRS ROUTE CASE 비용 산출 배치 작업 요청(7월) 건에 의해 발견된 부분 수정 세번째 
				    Cost 계산에서 사용되는 COA 의 데이터들을 지우는 로직 위치를 PCTL_NO 가 유효한 경우 처리하도록 변경                                                                  
 * 2012.08.06 송호진 CHM-201216347 : ACM 프로젝트 연동 모듈 변경 작업
                    New Agent Commission ( ACM ) Project 에 의한 Agt 호출 부분 변경 			                                                                  *
 * 2012.08.19 송호진 CHM-201431603 : 8월 PRS 배치작업 요청
                    SearchCondition0153VO 변경 부분 적용 
 * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
                    SearchCondition0153VO 변경 부분 적용 
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.common.PrdConstants;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.commutcostcalculation.basic.CommUtCostCalculationBC;
import com.hanjin.apps.alps.esm.acm.acmcalculation.commutcostcalculation.basic.CommUtCostCalculationBCImpl;
import com.hanjin.apps.alps.esm.mas.common.vo.CommonMasRsVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.basic.PreCMSimulationBC;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.basic.PreCMSimulationBCImpl;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration.PRICommonDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration.CalculateDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.PriPrsInCalculateVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsBatCalculateVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutActCostSimulationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutCsMaxRoutCsNoVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutEstmCostSimulationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsUsdRoutCsInfoSimulationVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration.TRIProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.PriTriRouteCaseNotFoundOthersVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
/**
 * CM/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
 * 
 * @author Min Seok, Song
 * @see 
 * @since J2EE 1.6
 */
public class TRIProposalCalculateBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -5625009436232931425L;

	private  TRIProposalDBDAO triDbDao = new TRIProposalDBDAO();
	private  CalculateDBDAO calcDbDao = new CalculateDBDAO();
	private  PRICommonDBDAO priCoDao = new PRICommonDBDAO();
	private PriPrsBatVO priPrsBatVO = new PriPrsBatVO();
	private SignOnUserAccount account;
	
	private PriPrsInCalculateVO priPrsInCalculateVO; 


	/**
	 * 조회를 위한 parameter를 셋팅한다. <br>
	 *  
	 * 
	 * @param RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO 
	 * @param PriPrsBatVO priPrsBatVO
	 * @param SignOnUserAccount account
	 * @return 
	 * @exception
	 */
	public void setSearchParameterVOs(PriPrsInCalculateVO priPrsInCalculateVO,PriPrsBatVO priPrsBatVO, SignOnUserAccount account ) {
		this.priPrsInCalculateVO = priPrsInCalculateVO;
		this.priPrsBatVO = priPrsBatVO;
		this.account = account;
	}

	/**
	 * CM/OP Summary & Simulation , Contract Approval 리스트 를 조회 합니다. <br>
	 *  
	 * @return DBRowSet
	 * @exception Exception
	 */
	public DBRowSet doStart() throws Exception {
		DBRowSet rowSet = null;
		String prsBatErrVal = "1.0";
		String prsBatErrDesc = "DEFAULT";
		String serverType = "";
 
 
		

		try {
 
			//oltpWrapper
			//("pri/SCProposalCalculate", "selectPRI_PRS_BAT" )
			List<RsltPriPrsBatCalculateVO>  vo = calcDbDao.searchPriPrsBatCalculateList(priPrsInCalculateVO);
			String routCsSrcDt  = vo.get(0).getParaInfoCtnt();
			String routCsClssNo = vo.get(0).getPrsBatId();
			priPrsInCalculateVO.setRoutCsSrcDt( routCsSrcDt );
			priPrsInCalculateVO.setRoutCsClssNo( routCsClssNo );
			priPrsInCalculateVO.setUpdUsrId("CALC");
			log.debug("routCsSrcDt="+routCsSrcDt);
			log.debug("routCsClssNo="+routCsClssNo);

			//oltpWrapper
			//("pri/TRICalculate", "updatePRI_TRI_RT_NULL")		
			triDbDao.modifyPriTriRtNullCalculate(priPrsInCalculateVO );
			
			
			/*****************************************************/
			/* 1.Route Case Cost - KEY DATE INSERT   	 		 */
			/*****************************************************/			
			prsBatErrVal = "1.2" ;
			/* AMENDMENT시 AMEND 하는 대상만 삭제  */				
			// oltpWrapper
			// ("pri/TRICalculate", "deletePRI_TRI_RT_USD_ROUT_CS_AMDT");	//TRIProposalDBDAOPriTriUsdRoutCsAmdtCalculateVODSQL.Query			
			triDbDao.removePriTriUsdRoutCsAmdtCalculate(priPrsInCalculateVO);
			log.info("1.Route Case Cost - KEY DATA DELETE END======================================");
	
			prsBatErrVal = "1.3" ;
			//oltpWrapper
			//("pri/TRICalculate", "insertPRI_TRI_RT_USD_ROUT_CS_OTHERS");	//TRIProposalDBDAOPriTriUsdRoutCsOthersCalculateVOCSQL.Query			
			triDbDao.addPriTriUsdRoutCsOthersCalculate(priPrsInCalculateVO);
			triDbDao.addPriTriUsdRoutCsOthers2Calculate(priPrsInCalculateVO); //5월 6일 추가
			
			log.info("1.Route Case Cost - KEY DATA INSERT END======================================");

			/*****************************************************/
	  		/* 2.USED ROUTE CASE COST INSERT     */
			/*****************************************************/
			prsBatErrVal = "2.1" ;
			//oltpWrapper
			//("pri/TRICalculate", "insertPRI_PRS_USD_ROUT_CS_INFO_OTHERS");  //TRIProposalDBDAOPriTriUsdRoutCsInfoOthersCalculateVOCSQL.Query
			triDbDao.addPriTriUsdRoutCsInfoOthersCalculate(priPrsInCalculateVO);

			//oltpWrapper
			//("pri/TRICalculate", "insertPRI_PRS_USD_ROUT_ACT_COST_OTHERS");  //TRIProposalDBDAOPriTriUsdRoutActCostOthersCalculateVOCSQL.Query
			triDbDao.addPriTriUsdRoutActCostOthersCalculate(priPrsInCalculateVO);
				
			log.info("2.END---insertUSEDRouteCaseInfo---------------------------------------------------------");
			
			


			/*****************************************************/
	  		/* 2. ROUTE CASE BATCH 에 없는 경우 
	  		 * 	1)배치에 없는 ROUTE CASE 에 대해서 배치에 INSERT 한다.
	  		 *  2)1번에 대해서 COA 로직을 태워서 COST를 추출한다.
	  		 *  3)KEY DATA INSERT 작업을 한다.
	  		 *  4)아래 로직을 그대로 태운다.
	  		 */
			/*****************************************************/			
			prsBatErrVal = "2.2" ;	

			//TRIProposalDBDAOPriTriRouteCaseNotFoundOthersVORSQL.Query
			//rt = oltpWrapper.getResultTable("pri/TRICalculate", "ROUTECASE_NOT_FOUND_OTHERS",ROUTECASE_NOT_FOUND_OTHERS_param);	
			List<PriTriRouteCaseNotFoundOthersVO>  routeCaseList = triDbDao.searchRouteCaseNotFoundOthersCalculateList( priPrsInCalculateVO );
			log.info("2-1.END---ROUTECASE_NOT_FOUND_OTHERS---------------------------------------------------------");
			

			
			//TRIProposalDBDAOPriTriRtUsdRoutCsCalculateCSQL
			//oltpWrapper
			//("pri/TRICalculate", "insertPRI_TRI_RT_USD_ROUT_CS");
			//for loop 안쪽에서 call함. -- triDbDao.addPriTriRtUsdRoutCsCalculate(routeCaseList.get(i));
			
			SearchCondition0153VO searchCondition0153VO = null;
			List<AbstractValueObject> abstractValueList = null;
			boolean bSuccessCOA = false;
			InPriPrsRoutCsVO inPriPrsRoutCsVO =null;

			for (int i = 0; i < routeCaseList.size(); i++) {
				inPriPrsRoutCsVO = new InPriPrsRoutCsVO();
				//String ROUT_CS_NO 			= (String) routeCaseList.get(i).getRoutCsNo();	
				String POR_CD				= (String) routeCaseList.get(i).getPorCd();
				String POL_CD				= (String) routeCaseList.get(i).getPolCd();
				String POD_CD				= (String) routeCaseList.get(i).getPodCd();
				String DEL_CD				= (String) routeCaseList.get(i).getDelCd();
				String BKG_RCV_TERM_CD		= (String) routeCaseList.get(i).getBkgRcvTermCd();
				String BKG_DE_TERM_CD		= (String) routeCaseList.get(i).getBkgDeTermCd();
				String BKG_OFC_CD			= (String) routeCaseList.get(i).getBkgOfcCd();
				String RAT_UT_CD			= (String) routeCaseList.get(i).getRatUtCd();
				String PRC_CGO_TP_CD		= (String) routeCaseList.get(i).getPrcCgoTpCd();
				String TEU_FRT_REV			= (String) routeCaseList.get(i).getPropFrtRtAmt();
				   
				if ( POL_CD == null) {
					POL_CD = "";
				}
				if ( POD_CD == null) {
					POD_CD = "";
				}

				int idx1 = 1;
				log.info("2-2.START---insertPRI_PRS_ROUTE_CS---------------------------------------------------------");
				//Batch DB에서 Rout_Cs_No의 max를 구한다.
				inPriPrsRoutCsVO.setRoutCsClssNo(routCsClssNo );
				RsltPriPrsRoutCsMaxRoutCsNoVO maxRoutCsVO = calcDbDao.searchPriPrsRoutCsMaxRoutCsNoCalculate(inPriPrsRoutCsVO);
				String ROUT_CS_NO = maxRoutCsVO.getRoutCsNo();
				
				//CalculateDBDAOPriPrsRoutCsCalculateCSQL.Query
				//PRS_HJSBAT
				//updateQry = batchWrapper.getQuery("pri/TRICalculate", "insertPRI_PRS_ROUTE_CS");
				//PreparedStatement pstmt1 = batchConn.prepareStatement(updateQry);
				routeCaseList.get(i).setRoutCsNo( ROUT_CS_NO );
				routeCaseList.get(i).setRoutCsClssNo( routCsClssNo );
				routeCaseList.get(i).setTeuFrtRev(TEU_FRT_REV );					
				calcDbDao.addPriPrsRoutCsCalculate( routeCaseList.get(i) );
				
				
				
//			calcDbDao.addPriPrsRoutCsCalculate( routeCaseList );를 이용해 한꺼번에 넣었음.		
//					pstmt1.setString(idx1++, ROUT_CS_NO);
//					pstmt1.setString(idx1++, routCsClssNo);
//					pstmt1.setString(idx1++, POR_CD);
//					pstmt1.setString(idx1++, POL_CD);
//					pstmt1.setString(idx1++, POD_CD);
//					pstmt1.setString(idx1++, DEL_CD);
//					pstmt1.setString(idx1++, BKG_RCV_TERM_CD);
//					pstmt1.setString(idx1++, BKG_DE_TERM_CD);
//					pstmt1.setString(idx1++, BKG_OFC_CD);
//					pstmt1.setString(idx1++, BKG_OFC_CD);
//					pstmt1.setString(idx1++, BKG_OFC_CD);
//					pstmt1.setString(idx1++, RAT_UT_CD);
//					pstmt1.setString(idx1++, PRC_CGO_TP_CD);
//					pstmt1.setString(idx1++, TEU_FRT_REV);
//					pstmt1.executeUpdate();

				log.info("2-2.END---insertPRI_PRS_ROUTE_CS---------------------------------------------------------");

				
				
				/************************************/
				/* 신규 ROUTE CASE COA 호출 			
				 * - PRI_PRS_ROUT_CS_INFO
				 * - PRI_PRS_ROUT_ACT_COST
				 * - PRI_PRS_ROUT_ESTM_COST DATA 생성 
				 */
				/*************************************/
				String PRS_ROUT_CS_BAT_RSLT_CD =  "E";//Fail
				
				try{
					bSuccessCOA = false;
					String CTRT_OFC_CD =  BKG_OFC_CD;
					String OB_SLS_OFC_CD =   BKG_OFC_CD;

					
					log.info("ROUT_CS_NO     	=  "+ROUT_CS_NO);
					log.info("ROUT_CS_SRC_DT     =  "+routCsSrcDt);
					log.info("POR_CD     		=  "+POR_CD);
					log.info("POL_CD     		=  "+POL_CD);
					log.info("POD_CD     		=  "+POD_CD);
					log.info("DEL_CD     		=  "+DEL_CD);
					log.info("BKG_RCV_TERM_CD    =  "+BKG_RCV_TERM_CD);
					log.info("BKG_DE_TERM_CD     =  "+BKG_DE_TERM_CD);
					log.info("CTRT_OFC_CD     	=  "+CTRT_OFC_CD);
					log.info("OB_SLS_OFC_CD      =  "+OB_SLS_OFC_CD);
					log.info("RAT_UT_CD     		=  "+RAT_UT_CD);
					log.info("PRC_CGO_TP_CD      =  "+PRC_CGO_TP_CD);
					log.info("TEU_FRT_REV     	=  "+TEU_FRT_REV);
					
					
//			    	   if( "DR".equals(PRC_CGO_TP_CD) && RAT_UT_CD.length() >= 2){
//			    		   String preUtCd = RAT_UT_CD.substring(0,1);
//			    		   if( preUtCd.equals("R")){
//			    			   RAT_UT_CD = "RD" +RAT_UT_CD.substring(1,2) ;
//			    			   PRC_CGO_TP_CD = "";
//			    		   }
//			    	   }
		    	   
		    	   
					
					
					searchCondition0153VO = new SearchCondition0153VO();
					/** Route Case 만들 호출을 위한 Parameter 생성 시작*/
					searchCondition0153VO.setFPcCreation("N");
					searchCondition0153VO.setFPorCd(POR_CD);
					searchCondition0153VO.setFPolCd(POL_CD);
					searchCondition0153VO.setFPodCd(POD_CD);
					searchCondition0153VO.setFDelCd(DEL_CD);
					searchCondition0153VO.setFSlsOfcCd(OB_SLS_OFC_CD);
					searchCondition0153VO.setFBkgOfcCd(BKG_OFC_CD);
					searchCondition0153VO.setFAgmtSgnOfcCd(CTRT_OFC_CD);
					searchCondition0153VO.setFCntrTpszCd(RAT_UT_CD);
					searchCondition0153VO.setFRTerm(BKG_RCV_TERM_CD);
					searchCondition0153VO.setFDTerm(BKG_DE_TERM_CD);
					searchCondition0153VO.setFGRev(TEU_FRT_REV);
					searchCondition0153VO.setFCobProfitLv("C");// CM
					searchCondition0153VO.setFCobProfitVw("R"); //Office Profit
					searchCondition0153VO.setFQty("1");// FIX된값			
					searchCondition0153VO.setFPorNode(""); 	// 필요없음			
					searchCondition0153VO.setFDelNode(""); 	// 필요없음
					searchCondition0153VO.setFCmdtCd(""); 	// 필요없음			
					searchCondition0153VO.setFNPol(""); 	// 필요없음
					searchCondition0153VO.setFLane1("");	// 필요없음
					searchCondition0153VO.setFPort1("");	// 필요없음
					searchCondition0153VO.setFPort2("");	// 필요없음
					searchCondition0153VO.setFLane2("");	// 필요없음
					searchCondition0153VO.setFPort3("");	// 필요없음
					searchCondition0153VO.setFLane3("");	// 필요없음
					searchCondition0153VO.setFNPod("");		// 필요없음
					searchCondition0153VO.setFLane4("");	// 필요없음
					searchCondition0153VO.setFMtyPkupYdCd("");	    // CHM-201218988 : PRS ROUTE CASE 비용 산출 배치 작업 요청(7월) 건에 의해 발견된 부분 수정 
					searchCondition0153VO.setFMtyPkupYdNode("");	// 신규로 추가된 2 개의 필드를 Blank 로 세팅하여 COA Method ( Procedure ) 를 호출 하도록 해야 함. 2012.07.12 - 송호진
					searchCondition0153VO.setFMtyRtnYdCd("");	    // CHM-201218988 : PRS ROUTE CASE 비용 산출 배치 작업 요청(7월) 건에 의해 발견된 부분 수정 
					searchCondition0153VO.setFMtyRtnYdNode("");	    // 신규로 추가된 2 개의 필드를 Blank 로 세팅하여 COA Method ( Procedure ) 를 호출 하도록 해야 함. 2012.07.12 - 송호진
					searchCondition0153VO.setFMtyRtnYdChk("");		// CHM-201431603 : 8월 PRS 배치작업 요청 - SearchCondition0153VO 변경사항 반영 F_MTY_PKUP_YD_CD_NODE -> F_MTY_PKUP_YD_NOTE, F_MTY_RTN_YD_CD_NODE -> F_MTY_RTN_YD_NODE, F_MTY_RTN_YD_CHK 신규 추가 - 2014.08.19 송호진
					// 샤시비용을 화주가 내는지 한진해운이 부담하는지 2개의 경우에 단가 값이다. (C : 화주부담, M : 한진해운 부담) 현업에 문의해야 하나 부재중이라 화주부담 [C]로 일단 고정하고 차후 문의한다. 2015.06.26
					searchCondition0153VO.setFChssTerm("C");			// CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청 - SearchCondition0153VO 변경사항 반영 F_CHSS_TERM
					
					// cargo type 적용
					if( "DG".equals(PRC_CGO_TP_CD) ){
						searchCondition0153VO.setFSpclDg("Y");
					}else if( "BB".equals(PRC_CGO_TP_CD) ){
						searchCondition0153VO.setFSpclBb("Y");
					}else if( "RF".equals(PRC_CGO_TP_CD) ){
						searchCondition0153VO.setFSpclRf("Y");
					}else if( "AK".equals(PRC_CGO_TP_CD) ){
						searchCondition0153VO.setFSpclAk("Y");
					}
					
					
					/** Route Case 만들 호출을 위한 Parameter 생성 종료*/
					abstractValueList = searchPreCMSimulationRoutList( searchCondition0153VO);
					CommonMasRsVO commonCoaRsVO  = (CommonMasRsVO)abstractValueList.get(0);
					DBRowSet dbRowSet = commonCoaRsVO.getDbRowset();
			        String PCTL_NO = null;
					String DYS_DMT = "";
			        if(dbRowSet.next()){
			        	PCTL_NO = dbRowSet.getString("pctl_no");
			        	if(PCTL_NO == null || PCTL_NO.length() == 0 ){
			        		throw new Exception("PCTL_NO IS NULL");
			        	}
			        	searchCondition0153VO.setFPctlNo(PCTL_NO);
			        	
						// CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청 - SearchCondition0153VO 변경사항 반영 CNTR_MT_DYS
			        	DYS_DMT = dbRowSet.getString("dys_dmt");
						searchCondition0153VO.setCntrMtDys(DYS_DMT);
			        	if(!DYS_DMT.contains("&")){
			        		DYS_DMT = DYS_DMT+"&null";
			        	}
			        }
			        searchCondition0153VO.setFUserId("BATCH");
			        searchCondition0153VO.setFVoidQty("0");
			        searchCondition0153VO.setFCobProfitLv("");
				         
				        
				        abstractValueList = searchPreCMSimulationCostList( searchCondition0153VO) ;
				        commonCoaRsVO  = (CommonMasRsVO)abstractValueList.get(0);

 
        
				        

					// CalculateDBDAOPriPrsUsdRoutCsInfoSimulationCSQL.Query
					//oltpWrapper
					//("pri/TRICalculate", "insertPRI_PRS_USD_ROUT_CS_INFO_COA")
					
					inPriPrsRoutCsVO.setRoutCsNo( ROUT_CS_NO );
					inPriPrsRoutCsVO.setRoutCsSrcDt( routCsSrcDt );
					inPriPrsRoutCsVO.setPctlNo(PCTL_NO);
					inPriPrsRoutCsVO.setUpdUsrId("CALC");
					int upCnt = calcDbDao.addPriPrsUsdRoutCsInfoSimulation(inPriPrsRoutCsVO);
					log.info("insertPRI_PRS_USD_ROUT_CS_INFO_COA=" + upCnt);

					if (upCnt != 0) { // info에 데이터를 넣지 못하면 cost와 estm을 넣지 않는다.
						
						//CalculateDBDAOPriPrsUsdRoutActCostSimulationCSQL.Query
						//oltpWrapper
						//("pri/TRICalculate", "insertPRI_PRS_USD_ROUT_ACT_COST_COA")
						upCnt = calcDbDao.addPriPrsUsdRoutActCostSimulation( inPriPrsRoutCsVO);
						log.info("insertPRI_PRS_USD_ROUT_ACT_COST_COA=" + upCnt);
						
						//CalculateDBDAOPriPrsUsdRoutEstmCostSimulationCSQL.Query
						//oltpWrapper
						//("pri/TRICalculate", "insertPRI_PRS_USD_ROUT_ESTM_COST_COA");
						upCnt = calcDbDao.addPriPrsUsdRoutEstmCostSimulation( inPriPrsRoutCsVO);
						log.info("insertPRI_PRS_USD_ROUT_ESTM_COST_COA=" + upCnt);

						//CalculateDBDAOPriPrsRoutCsMarkCalculateUSQL.Query
						//batchWrapper
						//("pri/TRICalculate","updateMARK_PRI_PRS_ROUT_CS_COA")
						priPrsInCalculateVO.setRoutCsNo(ROUT_CS_NO);
						upCnt = calcDbDao.modifyPriPrsRoutCsMarkCalculate( priPrsInCalculateVO);
						log.info("insertPRI_PRS_ROUT_CS_INFO=" + upCnt);
						
							routeCaseList.get(i);
							bSuccessCOA = true;	
							PRS_ROUT_CS_BAT_RSLT_CD = "S"; // 성공
			        }else{
			        	PRS_ROUT_CS_BAT_RSLT_CD = "C"; // Cost가 존재 하지 않음
			        }

				    /*
				    CHM-201218988 : PRS ROUTE CASE 비용 산출 배치 작업 요청(7월) 건에 의해 발견된 부분 수정 두번째 
				    Cost 계산에서 사용되는 COA 의 데이터들을 지우는 로직을 추가                                                                  
				        대상 테이블 : COA_COM_SVC_TRNS_PRC_PARA, COA_COM_COST_PARA, COA_COM_QTY_PARA, COA_COM_PARA 
				        삭제 순서 주의 사항 COA_COM_QTY_PARA 테이블 만  COA_COM_PARA 에 RK 가 걸려있음.
				        삭제 위치 옮김 PCTL_NO 가 유효한 경우라면 COST 가 존재여부 판단에 개의치 않고 해당 테이블 삭제 처리
				    2012.07.17 송호진 
				    */
					//CalculateDBDAOCoaComSvcTrnsPrcParaDSQL.Query
					//batchWrapper
					//("pri/CoaTableDataDelete", "deleteCOA_COM_SVC_TRNS_PRC_PARA");
					int delCnt = calcDbDao.deleteCoaComSvcTrnsPrcPara( inPriPrsRoutCsVO);
			        log.info("deleteCOA_COM_SVC_TRNS_PRC_PARA="+delCnt);
			        
					//CalculateDBDAOCoaComSvcTrnsPrcParaDSQL.Query
					//batchWrapper
					//("pri/CoaTableDataDelete", "deleteCOA_COM_COST_PARA");
			        delCnt =  calcDbDao.deleteCoaComCostPara(inPriPrsRoutCsVO);
			        log.info("deleteCOA_COM_COST_PARA="+delCnt);
			        
					//CalculateDBDAOCoaComSvcTrnsPrcParaDSQL.Query
					//batchWrapper
					//("pri/CoaTableDataDelete", "deleteCOA_COM_QTY_PARA");
			        delCnt = calcDbDao.deleteCoaComQtyPara(inPriPrsRoutCsVO);
			        log.info("deleteCOA_COM_QTY_PARA="+delCnt);
			        
					//CalculateDBDAOCoaComSvcTrnsPrcParaDSQL.Query
					//batchWrapper
					//("pri/CoaTableDataDelete", "deleteCOA_COM_PARA");
			        delCnt = calcDbDao.deleteCoaComPara(inPriPrsRoutCsVO);
			        log.info("deleteCOA_COM_PARA="+delCnt);

			        
				}catch(EventException e){
					
					ErrorHandler handler = new ErrorHandler(e);
					//code=1031,getType=ORA,getMessage= 권한이 불충분합니다
					//"code="+handler.getCode()+",getType="+handler.getType()+",getMessage="+handler.getUserMessage()
					//handler.getMessage() = ORA<||>1031<||>E<||> 권한이 불충분합니다
					//<||>ORA-01031: 권한이 불충분합니다
					log.info("***********************************************code="+handler.getCode()+",getType="+handler.getType()+",getMessage="+handler.getKind()+"EventException 수행중 에러  ===== "+ e.toString() +"====ROUT_CS_NO="+ROUT_CS_NO);
					if( "PRD00074".equals( handler.getCode()) ){
						PRS_ROUT_CS_BAT_RSLT_CD = "N"; //PC Fail
					}else{
						PRS_ROUT_CS_BAT_RSLT_CD = "E";// Error
					}
				
				}
		        //CalculateDBDAOPriPrsRoutCsFlgCalculateUSQL.Query
		        //batchWrapper
		        //("pri/TRICalculate", "updateMARK_PRI_PRS_ROUT_CS_FLG_COA");
		        priPrsInCalculateVO.setRoutCsNo(ROUT_CS_NO);
		        priPrsInCalculateVO.setPrsRoutCsBatRsltCd(PRS_ROUT_CS_BAT_RSLT_CD);
		        calcDbDao.modifyPriPrsRoutCsFlgCalculate(  priPrsInCalculateVO    );

				
				/*************************************/
				
				int idx2 = 1;
				
				//TRIProposalDBDAOPriTriRtUsdRoutCsCalculateCSQL
				//oltpWrapper
				//("pri/TRICalculate", "insertPRI_TRI_RT_USD_ROUT_CS");
				//rout_cs_src_dt
				routeCaseList.get(i).setRoutCsSrcDt( routCsSrcDt );
				triDbDao.addPriTriRtUsdRoutCsCalculate(routeCaseList.get(i));
		
		
				/*************************************/
				/* USED ROUTE CASE에 COPY			*/	
				/*************************************/
				log.info("*********************************************bSuccessCOA="+bSuccessCOA);
				if( bSuccessCOA ){

					Object[] copyParam = { routCsClssNo, ROUT_CS_NO , routCsSrcDt }; 
					//  PRI_PRS_ROUT_CS_INFO --> PRI_PRS_USD_ROUT_CS_INFO COPY 시작
					//CalculateDBDAORsltPriPrsUsdRoutCsInfoSimulationVORSQL.Query
					//oltpWrapper
					//("pri/TRICalculate", "selectPRI_PRS_USD_ROUT_CS_INFO_COA")
					inPriPrsRoutCsVO.setRoutCsClssNo(routCsClssNo);
					List<RsltPriPrsUsdRoutCsInfoSimulationVO> infoList = calcDbDao.searchPriPrsUsdRoutCsInfoSimulationList(inPriPrsRoutCsVO);
					if( infoList != null && infoList.size() > 0 ){
						//CalculateDBDAOPriPrsRoutCsInfoSimulationCSQL.Query
						//batchWrapper
						//("pri/TRICalculate", "insertPRI_PRS_ROUT_CS_INFO_COA");  
						calcDbDao.addPriPrsRoutCsInfoSimulation(infoList);
						log.info("*********************************************insertPRI_PRS_ROUT_CS_INFO=");
						
						//  PRI_PRS_ROUT_CS_INFO --> selectPRI_PRS_ROUT_ACT_COST COPY 시작
						//CalculateDBDAORsltPriPrsRoutActCostSimulationVORSQL.Query
						//oltpWrapper
						//("pri/TRICalculate", "selectPRI_PRS_USD_ROUT_ACT_COST_COA")
						List<RsltPriPrsRoutActCostSimulationVO> actCostList = calcDbDao.searchPriPrsRoutActCostSimulationList(inPriPrsRoutCsVO);
						//CalculateDBDAOPriPrsRoutActCostSimulationCSQL.Query
						//batchWrapper
						//("pri/TRICalculate", "insertPRI_PRS_ROUT_ACT_COST_COA");
						 calcDbDao.addPriPrsRoutActCostSimulation(actCostList);
						log.info("*********************************************insertPRI_PRS_ROUT_ACT_COST");
						
						//  PRI_PRS_ROUT_CS_INFO --> selectPRI_PRS_ROUT_ESTM_COST COPY 시작
						// CalculateDBDAORsltPriPrsRoutEstmCostSimulationVORSQL.Query
						// oltpWrapper
						// ("pri/TRICalculate", "selectPRI_PRS_USD_ROUT_ESTM_COST_COA")
					 	List<RsltPriPrsRoutEstmCostSimulationVO> estmCostList = calcDbDao.searchPriPrsRoutEstmCostSimulationList(inPriPrsRoutCsVO);
						//CalculateDBDAOPriPrsRoutEstmCostSimulationCSQL.Query
						// batchWrapper
					 	// ("pri/TRICalculate", "insertPRI_PRS_ROUT_ESTM_COST_COA")  
						log.info("*********************************************insertPRI_PRS_ROUT_ESTM_COST=");
						 	calcDbDao.addPriPrsRoutEstmCostSimulation(estmCostList);
						 
						}
  
							  
				}				
			}
 

			/*****************************************************/
			/* 4-2.Pattern 정보 이용한 Route Case 매핑으로 실적 조회   */
			/*   - TRANSIT TIME 기준으로  COST 를 선택한다.	 	 */
			/*****************************************************/
			prsBatErrVal = "4.21" ;			
			//TRIProposalDBDAOPriTriRtUsdRoutCsTransitTimeCalculateUSQL.Query
			//oltpWrapper
			//("pri/TRICalculate", "updatePRI_TRI_RT_USD_ROUT_CS_TransitTime")
			triDbDao.modifyPriTriRtUsdRoutCsTransitTimeCalculate( priPrsInCalculateVO);
			

			prsBatErrVal = "4.22" ;
			//TRIProposalDBDAOPriTriRtTransitTimeCalculateUSQL.Query
			//oltpWrapper
			//("pri/TRICalculate", "updateCM_OP_PRI_TRI_RT_TransitTime");  
			triDbDao.modifyPriTriRtTransitTimeCalculate(priPrsInCalculateVO);
			log.info("3.END---updateRouteCaseCost---------------------------------------------------------");
			
			/******************************************************************************************
			COST DETAIL 조회에서 데이터 변경시 적용 
			1.START
			******************************************************************************************/
					

			//SCProposalCalculate Logic시작
			RsltTriPrsCostListVO rsltTriPrsCostListVO = new RsltTriPrsCostListVO();
			rsltTriPrsCostListVO.setTriPropNo(priPrsInCalculateVO.getTriPropNo() );
			rsltTriPrsCostListVO.setAmdtSeq(priPrsInCalculateVO.getAmdtSeq());
			rsltTriPrsCostListVO.setUpdUsrId("CALC");
			 
			
				
			
			
			/*****************************************************/
			/* 5.Route Case 에 해당하는 Surcharge Data 배치에서 선택 */
			/*****************************************************/
			prsBatErrVal = "5.1" ;
			/* 5-1.모두 삭제하고 새로 insert 한다. */
			//Object[] deletePRI_TRI_RT_SCG_ROUT_param = {TRI_PROP_NO, AMDT_SEQ};
			//oltpWrapper.update("pri/TRICalculate", "deletePRI_TRI_RT_SCG_ROUT",deletePRI_TRI_RT_SCG_ROUT_param);  
			triDbDao.removePriTriRtScgRoutCostDetail(rsltTriPrsCostListVO);

			
			prsBatErrVal = "5.2" ;
			/* 5-2.SURCHARGE DETAIL의 ROUTE 정보를 INSERT 한다. */
			//Object[] insertPRI_TRI_RT_SCG_ROUT_param = {USER_ID, USER_ID, TRI_PROP_NO, AMDT_SEQ};
			//oltpWrapper.update("pri/TRICalculate", "insertPRI_TRI_RT_SCG_ROUT",insertPRI_TRI_RT_SCG_ROUT_param);  
			triDbDao.addPriTriRtScgRoutCostDetail(rsltTriPrsCostListVO);

			
			prsBatErrVal = "5.3" ;
			/* 5-3.사용자 입력 건은 제외하고 데이터 삭제한다. */
			//Object[] deletePRI_TRI_RT_SCG_param = {TRI_PROP_NO, AMDT_SEQ};
			//oltpWrapper.update("pri/TRICalculate", "deletePRI_TRI_RT_SCG",deletePRI_TRI_RT_SCG_param);  
			triDbDao.removePriTriRtScgCostDetail(rsltTriPrsCostListVO);
	
			
			prsBatErrVal = "5.4" ;
			/* 5-4.SURCHARGE RATING 수행 -MAERGE 문 이용하여 INSERT & UPDATE */
			//Object[] insert_PRI_TRI_RT_SCG_param = {TRI_PROP_NO, AMDT_SEQ, TRI_PROP_NO, AMDT_SEQ, USER_ID, USER_ID, USER_ID };
			//oltpWrapper.update("pri/TRICalculate", "insert_PRI_TRI_RT_SCG",insert_PRI_TRI_RT_SCG_param);  
			triDbDao.addPriTriRtScgCostDetail(rsltTriPrsCostListVO);

			
			log.info("5_2.updateSURCHARGE_PRI_TRI_RT---------------------------------------------------------");

			prsBatErrVal = "5.5" ;
			/* 5-6.RATE 에 SURCHARGE SUM DATA UPDATE */
			//Object[] updateSURCHARGE_PRI_TRI_RT_param = {TRI_PROP_NO, AMDT_SEQ};
			//oltpWrapper.update("pri/TRICalculate", "updateSURCHARGE_PRI_TRI_RT",updateSURCHARGE_PRI_TRI_RT_param);  
			triDbDao.modifyPriTriRtSurchargeCostDetail(rsltTriPrsCostListVO);

			
			/*****************************************************/
			/* 6.PROPOSAL RATE + SURCHARGE - COST = CMPB 		 */			
			/*****************************************************/
			prsBatErrVal = "6.1" ;
			//Object[] updatePRI_TRI_RT_CMPB_param = {TRI_PROP_NO, AMDT_SEQ };
			//oltpWrapper.update("pri/TRICalculate", "updatePRI_TRI_RT_CMPB",updatePRI_TRI_RT_CMPB_param);  
			triDbDao.modifyPriTriRtCMPBCostDetail(rsltTriPrsCostListVO);
			
			/*****************************************************/
			/*7.RATE별 SVC LANE UPDATE 및  CMPB GUIDELINE MATCHING */			
			/*****************************************************/
			prsBatErrVal = "7.1" ;
			//Object[] updatePRI_TRI_RT_SVC_LANE_param = {TRI_PROP_NO, AMDT_SEQ };
			//oltpWrapper.update("pri/TRICalculate", "updatePRI_TRI_RT_SVC_LANE",updatePRI_TRI_RT_SVC_LANE_param);  
			triDbDao.modifyPriTriRtSvcLaneCostDetail(rsltTriPrsCostListVO);
			
			prsBatErrVal = "7.2" ;
			//Object[] updateGLINE_MAPPING_param = { TRI_PROP_NO, 
			//									   TRI_PROP_NO, AMDT_SEQ }; 			
			//oltpWrapper.update("pri/TRICalculate", "updateGLINE_MAPPING",updateGLINE_MAPPING_param);		
			triDbDao.modifyPriTriRtGlineMappingCostDetail(rsltTriPrsCostListVO);
			
			
		/******************************************************************************************
			COST DETAIL 조회에서 데이터 변경시 적용 
			1.END
		******************************************************************************************/

			/*****************************************************/
			/* 8-4.배치 수행 년월로 환률 기준 세팅					 */
			/*****************************************************/
			prsBatErrVal = "8.4" ;
			//TRIProposalDBDAOPriTriMnPrsXchRtYrMonCalculateUSQL.Query
			//oltpWrapper
			//("pri/TRICalculate", "updatePRI_TRI_MN_PRS_XCH_RT_YRMON")  
			triDbDao.modifyPriTriMnPrsXchRtYrMonCalculate(priPrsInCalculateVO);
			log.info("8_4.updatePRI_TRI_MN---------------------------------------------------------");
			
			
			/* 해당 PROCESS 의 성공여부를 LOG 로 남긴다. */			
			prsBatErrVal = "0" ;
			prsBatErrDesc = "Success" ;
			
			
			
		} catch (DAOException ex) {
			/* 해당 PROCESS 의 ErrorLog를  남긴다. */			
			prsBatErrDesc = ex.toString();
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			/* 해당 PROCESS 의 ErrorLog를  남긴다. */			
			prsBatErrDesc = ex.toString();
			throw new EventException(ex.getMessage(),ex);
		}finally{
//			priPrsBatVO.setPrsBatErrVal(prsBatErrVal);
//			priPrsBatVO.setPrsBatErrDesc(prsBatErrDesc);
//			priCoDao.modifyPrsBatchLog(priPrsBatVO);
			
			log.info("==================================================================================" );
			log.info("============  Error Flag : " + prsBatErrVal + ", Error Desc : " + prsBatErrDesc );
			log.info("==================================================================================" );
			

			//CALCULATE 수행시 수행 FLAG를 'Y' 로 세팅한다.
			//Object[] updatePRI_TRI_MN_GEN_param = { TRI_PROP_NO, TRI_PROP_NO, AMDT_SEQ };	
			//TRIProposalDBDAOPriTriMnCalcFlgCalculateUSQL.Query
			//oltpWrapper.update("pri/TRICalculate", "updatePRI_TRI_MN_GEN",updatePRI_TRI_MN_GEN_param);  							
			triDbDao.modifyPriTriMnCalcFlgCalculate(priPrsInCalculateVO);
			
		}
		return rowSet;
	}
	
	

	
	
	private String createPreCMSimulation(SearchCondition0153VO searchCondition0153VO ) throws EventException {
        log.info("===================================================================================================");
        log.info("===============     createPreCMSimulation      시작          =============================");
        log.info("===================================================================================================");		

		String msg = "";
		String cost_yrmon = "";
		
		try {
			log.info("\n### PARA");
			PreCMSimulationBC command = new PreCMSimulationBCImpl();
			msg = command.createCostAssignPreCM(searchCondition0153VO);
			log.info("\n### createCostAssignPreCM msg =" + msg);			
			//if(msg != null) {
				cost_yrmon = command.searchBzcCostYrmon();
			//}
			searchCondition0153VO.setFCostYrmon(cost_yrmon);
			log.info("\n### COST_YRMON="+cost_yrmon);
			msg = command.createTrsAgmtApplyToMas(searchCondition0153VO);
			log.info("\n### TRS msg= " +msg);
			msg = command.createTesMasRate(searchCondition0153VO);
			log.info("\n### TES msg= " +msg);
			msg = command.createMasCostPkgMainPreCMAvg(searchCondition0153VO);
			log.info("\n### MASPKG msg= " +msg);			
			msg = command.createMasCostPkgPreCMAbcStp(searchCondition0153VO);
			log.info("\n### MAS ABC msg= " +msg);
			
			// -------------------------------------------AGT START
			//timeSub = System.currentTimeMillis();
			log.info("\n### New AGT Commission start");
			CommUtCostCalculationBC commUtCostCalculationBC = new CommUtCostCalculationBCImpl();
			commUtCostCalculationBC.createCommUtCostCalculation(JSPUtil.getNull(searchCondition0153VO.getFPctlNo()), JSPUtil.getNull(searchCondition0153VO.getFUserId()));
			
			log.info("\n### New AGT Commission end");			
			//log.info("\n### Time: " + dateFormat.format(new Date(System.currentTimeMillis() - timeSub)));
			// -------------------------------------------AGT END
			
			msg = command.createMasCostPkgMainComTtl(searchCondition0153VO);
			log.info("\n### TTL msg=" + msg);
 
		}catch(Exception e){
			log.error(e.toString());
		}
        log.info("===================================================================================================");
        log.info("===============     createPreCMSimulation      종료          =============================");
        log.info("===================================================================================================");			
		return msg;
	}
	
	
	private  List<AbstractValueObject>  searchPreCMSimulationCostList(SearchCondition0153VO searchCondition0153VO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
        log.info("===================================================================================================");
        log.info("===============     searchPreCMSimulationCostList      시작          =============================");
        log.info("===================================================================================================");	
		PreCMSimulationBC command = new PreCMSimulationBCImpl();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		String msg = "";

		try{
			msg = this.createPreCMSimulation(searchCondition0153VO);
			if(msg != null) {
				CommonMasRsVO commonCoaRsVO = command.searchPreCMSimulationCostList(searchCondition0153VO);
				commonCoaRsVO.setConditionVO((Object)(searchCondition0153VO));
				commonCoaRsVO.setEventName("GS2");
				returnVOList.add(commonCoaRsVO);
			}
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        log.info("===================================================================================================");
        log.info("===============     searchPreCMSimulationCostList      종료          =============================");
        log.info("===================================================================================================");			
		return returnVOList;
	}	
	
	
	
	
	



	private List<AbstractValueObject> searchPreCMSimulationRoutList(SearchCondition0153VO searchCondition0153VO) throws EventException {
		EsdPrd0080Event event0080 = new EsdPrd0080Event(); //ADD
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
	        log.info("===================================================================================================");
	        log.info("===============     searchPreCMSimulationRoutList      시작          =============================");
	        log.info("===================================================================================================");		
			
			//SearchCondition0153VO searchCondition0153VO = coaEvent.getSearchCondition0153VO();

			PrdCreateParamVO prdCreateParamVO = new PrdCreateParamVO();
			// PreCMSimulationBC command = new PreCMSimulationBCImpl();
			// PRD의 BC를 호출하여 ROUTE LIST를 만들어 가져온다
			// PRDUCT createPRDList
			
			if(JSPUtil.getNull(searchCondition0153VO.getFPcCreation()).equals("Y")){
				prdCreateParamVO.setPcMode(PrdConstants.PRD_PC_MOD_N);
			} else {
				prdCreateParamVO.setPcMode(PrdConstants.PRD_PC_MOD_T);
			}

			prdCreateParamVO.setPor			( JSPUtil.getNull(searchCondition0153VO.getFPorCd()) );
			prdCreateParamVO.setPorN		( JSPUtil.getNull(searchCondition0153VO.getFPorNode()) );
			prdCreateParamVO.setPol			( JSPUtil.getNull(searchCondition0153VO.getFPolCd()) );
			prdCreateParamVO.setPod			( JSPUtil.getNull(searchCondition0153VO.getFPodCd()) );
			prdCreateParamVO.setDel			( JSPUtil.getNull(searchCondition0153VO.getFDelCd()) );
			prdCreateParamVO.setDelN		( JSPUtil.getNull(searchCondition0153VO.getFDelNode()) );
			String Por = JSPUtil.getNull(searchCondition0153VO.getFPorCd());
			String LdDt = "";
//			if ( Por.equals("CNFOC")) {
//				LdDt = "20090728";
//			} else if ( Por.equals("KRPUS")) {
//				LdDt = "20090630";
//			}
			prdCreateParamVO.setLdDt		( LdDt );
			prdCreateParamVO.setInternalSkdType		("L"); // setSkdType		("D");  sysdate
			prdCreateParamVO.setCom			( JSPUtil.getNull(searchCondition0153VO.getFCmdtCd()) );
			prdCreateParamVO.setScOfc		(  JSPUtil.getNull(searchCondition0153VO.getFSlsOfcCd()) );
			prdCreateParamVO.setBkgOfc		( JSPUtil.getNull(searchCondition0153VO.getFBkgOfcCd()) );
			
			// 2011.10.18 일 COA.MultiDimensionRPTSC 에 수정 추가된 부분 뒤늦게 발견하여 수정함.
			// 2012.09.18 송호진
			prdCreateParamVO.setDgF		( JSPUtil.getNull(searchCondition0153VO.getFSpclDg()) );	//DG
			prdCreateParamVO.setRfF		( JSPUtil.getNull(searchCondition0153VO.getFSpclRf()) );	//RF
			prdCreateParamVO.setAkF		( JSPUtil.getNull(searchCondition0153VO.getFSpclAk()) );	//AK
			prdCreateParamVO.setBbF		( JSPUtil.getNull(searchCondition0153VO.getFSpclBb()) );	//BB
			// 아래의 S.O.C 와 Revenue MT 부분은 현재로서는 사용되지 않으므로 제외 한다. 2012.09.18 송호진
			// prdCreateParamVO.setSocF	( JSPUtil.getNull(searchCondition0153VO.getFSpclSoc()) );	//S.O.C
			// prdCreateParamVO.setCgoTp	( JSPUtil.getNull(searchCondition0153VO.getFSpclRevmt()) );	//Revenue MT
			
			String[] arrConType = new String[] {JSPUtil.getNull(searchCondition0153VO.getFCntrTpszCd())};
			String[] arrConQty  = new String[] {JSPUtil.getNull(searchCondition0153VO.getFQty())};
			PrdQuantityVO[] prdQuantityVOs = new PrdQuantityVO[arrConType.length];
			
			for (int i = 0; i < arrConType.length; i++) {
				PrdQuantityVO prdQuantityVO = new PrdQuantityVO();
				prdQuantityVO.setCTpsz(arrConType[i]);
				prdQuantityVO.setCQty(arrConQty[i]);				
				prdQuantityVOs[i] = prdQuantityVO;
			}
			prdCreateParamVO.setRcvT		( JSPUtil.getNull(searchCondition0153VO.getFRTerm()));
			prdCreateParamVO.setDelT		( JSPUtil.getNull(searchCondition0153VO.getFDTerm()));

			if(JSPUtil.getNull(searchCondition0153VO.getFPcCreation()).equals("Y")){
				//TS 횟수에 따라 넘겨주는 값이 다르다.     
				if(JSPUtil.getNull(searchCondition0153VO.getFPort1()).equals("")){ // 0번 TS
					prdCreateParamVO.setPol1	( JSPUtil.getNull(searchCondition0153VO.getFNPol()));
					prdCreateParamVO.setPod1	( JSPUtil.getNull(searchCondition0153VO.getFNPod()));
					prdCreateParamVO.setLane1	( JSPUtil.getNull(searchCondition0153VO.getFLane1()));
					prdCreateParamVO.setPol2	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod2	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane2	( JSPUtil.getNull(""));
					prdCreateParamVO.setPol3	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod3	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane3	( JSPUtil.getNull(""));
					prdCreateParamVO.setPol4	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod4	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane4	( JSPUtil.getNull(""));
				} else if(JSPUtil.getNull(searchCondition0153VO.getFPort2()).equals("")){ //1번 TS 
					prdCreateParamVO.setPol1	( JSPUtil.getNull(searchCondition0153VO.getFNPol()));
					prdCreateParamVO.setPod1	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setLane1	( JSPUtil.getNull(searchCondition0153VO.getFLane1()));
					prdCreateParamVO.setPol2	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setPod2	( JSPUtil.getNull(searchCondition0153VO.getFNPod()));
					prdCreateParamVO.setLane2	( JSPUtil.getNull(searchCondition0153VO.getFLane2()));
					prdCreateParamVO.setPol3	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod3	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane3	( JSPUtil.getNull(""));
					prdCreateParamVO.setPol4	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod4	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane4	( JSPUtil.getNull(""));
				} else if(JSPUtil.getNull(searchCondition0153VO.getFPort3()).equals("")){ //2번 TS 
					prdCreateParamVO.setPol1	( JSPUtil.getNull(searchCondition0153VO.getFNPol()));
					prdCreateParamVO.setPod1	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setLane1	( JSPUtil.getNull(searchCondition0153VO.getFLane1()));
					prdCreateParamVO.setPol2	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setPod2	( JSPUtil.getNull(searchCondition0153VO.getFPort2()));
					prdCreateParamVO.setLane2	( JSPUtil.getNull(searchCondition0153VO.getFLane2()));
					prdCreateParamVO.setPol3	( JSPUtil.getNull(searchCondition0153VO.getFPort2()));
					prdCreateParamVO.setPod3	( JSPUtil.getNull(searchCondition0153VO.getFNPod()));
					prdCreateParamVO.setLane3	( JSPUtil.getNull(searchCondition0153VO.getFLane3()));
					prdCreateParamVO.setPol4	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod4	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane4	( JSPUtil.getNull(""));
				} else { //3번 TS
					prdCreateParamVO.setPol1	( JSPUtil.getNull(searchCondition0153VO.getFNPol()));
					prdCreateParamVO.setPod1	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setLane1	( JSPUtil.getNull(searchCondition0153VO.getFLane1()));
					prdCreateParamVO.setPol2	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setPod2	( JSPUtil.getNull(searchCondition0153VO.getFPort2()));
					prdCreateParamVO.setLane2	( JSPUtil.getNull(searchCondition0153VO.getFLane2()));
					prdCreateParamVO.setPol3	( JSPUtil.getNull(searchCondition0153VO.getFPort2()));
					prdCreateParamVO.setPod3	( JSPUtil.getNull(searchCondition0153VO.getFPort3()));
					prdCreateParamVO.setLane3	( JSPUtil.getNull(searchCondition0153VO.getFLane3()));
					prdCreateParamVO.setPol4	( JSPUtil.getNull(searchCondition0153VO.getFPort3()));
					prdCreateParamVO.setPod4	( JSPUtil.getNull(searchCondition0153VO.getFNPod()));
					prdCreateParamVO.setLane4	( JSPUtil.getNull(searchCondition0153VO.getFLane4()));
				} 
			} 

			event0080.setPrdCreateParamVO(prdCreateParamVO);
			event0080.setPrdQuantityVOs(prdQuantityVOs);

			// -----------------------------------------------------------------------------------
 

			ProductCatalogCreateBC command = new ProductCatalogCreateBCImpl();

			// master 생성 및 조회
			CommonMasRsVO commonCoaRsVO = new CommonMasRsVO();
			
			SignOnUserAccount account = new SignOnUserAccount("BATCH", "BATCH", "",
					"","", "", "",
					"", "BATCH", "",
					"BATCH", "", "", "",
					"", "", "",
					"", "", "",
					"","");
 
			event0080.setAttribute("com.hanjin.component.signon.SIGN_ON_USER_ACCOUNT", account);
			event0080.setAttribute("account", account);
			commonCoaRsVO.setDbRowset(command.createPrdCtlgFullRoutForCOAMAS(event0080));
			commonCoaRsVO.setEventName("GS");
			returnVOList.add(commonCoaRsVO);

		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        log.info("===================================================================================================");
        log.info("===============     searchPreCMSimulationRoutList      종료          =============================");
        log.info("===================================================================================================");		
		return returnVOList;
	}		
	
}
