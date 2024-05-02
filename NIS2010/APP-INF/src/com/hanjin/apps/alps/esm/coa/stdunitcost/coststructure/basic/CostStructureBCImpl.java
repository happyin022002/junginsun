/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CostStructureBC.java
*@FileTitle : 물류비용 코드 등록, 전사계정과목 등록
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 김기식
*@LastVersion : 1.22
* 2006-10-13 OKYOUNG IM
* 1.0 최초 생성
* 2009.07.09 김기대  New Framework 적용 [0002]
* 2009.07.10 박은주  New Framework 적용 [0001]
* 2009.08.03 전윤주  New Framework 적용 [0140]
* 2009.08.21 장영석  New Framework 적용 [0139]
* 2009.08.28 임옥영  New Framework 적용 [0137]
* 2009.10.07 장영석  New Framework 적용 [0160]
* 2009.10.21 김기식  New Framework 적용 [0003] 
* 2010.02.09 전윤주 Flag 값을 Y,N으로 변경해주는 logic 처리 [0002]
* 2010.03.08 upd_usr_id 값 setting 해주는 부분 추가 [0139]
* 2010.03.09 박은주  multiSpclRepoCntr flag 관련 10->YN 처리함
* 2010.06.17 이행지 Ticket ID:ITM-201001650 - GeneralEventResponse => void로 변경, 실제 return 되는 값이 없어서
* 2012.05.07 전윤주 [CHM-201217633] Hinterland Project 
*                 - TRS cost table 생성 시 사용되는 계정 분리를 위해 Flag 추가
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.Utils;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration.CostStructureDBDAO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.CoaAgmtRstrMgmtConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.CostStructureCommonVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.GetVariableheader2VO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.NodLnkCostCodeVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.SearchCostCodeListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0139ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0140ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.SearchSoCode0160ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.SearchSoCodeListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.CostStructureSoCodeRtnVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.CostStructureConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.SpclRepoCntrVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.TableColumnVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.InqOffice0138VO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaSpclRepoCntrRgstVO;
import com.hanjin.syscommon.common.table.CoaStndAcctVO;
import com.hanjin.syscommon.common.table.CoaTrnsFdrTermVO;
import com.hanjin.syscommon.common.table.CoaTrnsTermCalcVO;


/**
 * eNIS-COA Business Logic Basic Command implementation<br>
 * - eNIS-COA에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author OKYOUNG IM
 * @see ESM_COA_002EventResponse,CostStructureBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CostStructureBCImpl extends BasicCommandSupport implements CostStructureBC {

	// Database Access Object
	private transient CostStructureDBDAO dbDao=null;
	
	//EAI object
	//private transient CostStructureEAIDAO eaiDao = null;

	/**
	 * CostStructureBCImpl 객체 생성<br>
	 * CostStructureDBDAO를 생성한다.<br> 
	 */
	public CostStructureBCImpl(){
		dbDao = new CostStructureDBDAO();
		//eaiDao = new CostStructureEAIDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0001(Set List Box)화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return List<SpclRepoCntrVO>
	 * @exception EventException
	 */
	public List<SpclRepoCntrVO> searchSpclRepoCntrList() throws EventException {
		try {
			return dbDao.searchSpclRepoCntrList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_0001(Set List Box)화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param CoaSpclRepoCntrRgstVO[] coaSpclRepoCntrRgstVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpclRepoCntr(CoaSpclRepoCntrRgstVO[] coaSpclRepoCntrRgstVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaSpclRepoCntrRgstVO> insertVoList = new ArrayList<CoaSpclRepoCntrRgstVO>();
			List<CoaSpclRepoCntrRgstVO> updateVoList = new ArrayList<CoaSpclRepoCntrRgstVO>();
			List<CoaSpclRepoCntrRgstVO> deleteVoList = new ArrayList<CoaSpclRepoCntrRgstVO>();
			
			for ( int i=0; i<coaSpclRepoCntrRgstVO.length; i++ ) {
				if ( coaSpclRepoCntrRgstVO[i].getIbflag().equals("I")){
					coaSpclRepoCntrRgstVO[i].setRepoFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getRepoFlg()));
					coaSpclRepoCntrRgstVO[i].setSpclCgoFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getSpclCgoFlg()));
					coaSpclRepoCntrRgstVO[i].setDeltFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getDeltFlg()));
					coaSpclRepoCntrRgstVO[i].setCreUsrId(account.getUsr_id());
					coaSpclRepoCntrRgstVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(coaSpclRepoCntrRgstVO[i]);
				} else if ( coaSpclRepoCntrRgstVO[i].getIbflag().equals("U")){
					coaSpclRepoCntrRgstVO[i].setRepoFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getRepoFlg()));
					coaSpclRepoCntrRgstVO[i].setSpclCgoFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getSpclCgoFlg()));
					coaSpclRepoCntrRgstVO[i].setDeltFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getDeltFlg()));
					coaSpclRepoCntrRgstVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaSpclRepoCntrRgstVO[i]);
				} else if ( coaSpclRepoCntrRgstVO[i].getIbflag().equals("D")){
					coaSpclRepoCntrRgstVO[i].setDeltFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getDeltFlg()));
					deleteVoList.add(coaSpclRepoCntrRgstVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSpclRepoCntr(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySpclRepoCntr(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSpclRepoCntr(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0002(Cost Element)화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO  searchVo
	 * @return List<SearchCostCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCostCodeListVO> searchCostCodeList(SearchConditionVO searchVo) throws EventException {
		try {
			CostStructureCommonVO vo = new CostStructureCommonVO();
			vo.setIndirectColumnValues(searchVo.getColumnValues());
			return dbDao.searchCostCodeList(vo);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}	

	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_0002(Cost Element)화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param CoaStndAcctVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiCostCode(CoaStndAcctVO[] vos, String userId) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try{
			List createList = new ArrayList();
			List updateList = new ArrayList();
			List deleteList = new ArrayList();	     

			// 
			//----------------------------------------------------
            if(vos.length > 0){
                for(int i = 0 ; i < vos.length ; i++){

                    if(vos[i].getIbflag().equals("I")) {
                        //query parameter
                        HashMap<String, String> param = new HashMap<String, String>();
                        param.put("stnd_cost_cd"	  , vos[i].getStndCostCd()	);
                        param.put("stnd_cost_nm"	  , vos[i].getStndCostNm()	);
                        param.put("mgrp_cost_cd"	  , vos[i].getMgrpCostCd()	);
                        param.put("sgrp_cost_cd"	  , vos[i].getSgrpCostCd()	);
                        param.put("perf_vw_cd"        , vos[i].getPerfVwCd()	);
                        param.put("krn_cost_full_desc", vos[i].getKrnCostFullDesc());
                        param.put("ra_acct_cd"        , vos[i].getRaAcctCd()	);
                        param.put("ra_mn_cost_cd"     , vos[i].getRaMnCostCd()	);
                        param.put("ra_sgrp_cost_cd"   , vos[i].getRaSgrpCostCd());
                        param.put("ra_perf_vw_cd"     , vos[i].getRaPerfVwCd()	);
                        param.put("hir_scp_flg"       , Utils.change10ToYN(vos[i].getHirScpFlg()));	
                        param.put("upd_usr_id"        , userId					);
                        param.put("upd_usr_id"        , userId					);
                        createList.add(param);
                    }
                    else if(vos[i].getIbflag().equals("U")) {
                    	
                        //query parameter
                    	HashMap<String, String> param = new HashMap<String, String>();
                    	param.put("delt_flg"          , Utils.change10ToYN(vos[i].getDeltFlg()));
                    	param.put("stnd_cost_nm"      , vos[i].getStndCostNm()     );
                    	param.put("mgrp_cost_cd"      , vos[i].getMgrpCostCd()     );
                    	param.put("sgrp_cost_cd"      , vos[i].getSgrpCostCd()     );
                    	param.put("perf_vw_cd"        , vos[i].getPerfVwCd()       );
                    	param.put("krn_cost_full_desc", vos[i].getKrnCostFullDesc());
                    	param.put("ra_acct_cd"        , vos[i].getRaAcctCd()       );
                    	param.put("ra_mn_cost_cd"     , vos[i].getRaMnCostCd()     );
                    	param.put("ra_sgrp_cost_cd"   , vos[i].getRaSgrpCostCd()   );
                	  	param.put("ra_perf_vw_cd"     , vos[i].getRaPerfVwCd()     );
                	  	param.put("hir_scp_flg"       , Utils.change10ToYN(vos[i].getHirScpFlg()));
                	  	param.put("upd_usr_id"        , userId                     );
                	  	param.put("stnd_cost_cd"      , vos[i].getStndCostCd()     );
                        updateList.add(param);
                    }
                    else if(vos[i].getIbflag().equals("D")) {
                        //query parameter
                    	HashMap<String, String> param = new HashMap<String, String>();
                    	param.put("upd_usr_id"  , userId                );
                        param.put("stnd_cost_cd", vos[i].getStndCostCd());
                    	deleteList.add(param);
                    }                        
                }
            }    
            
            CostStructureCommonVO vo = new CostStructureCommonVO();
            vo.setMultiCreateList(createList);
            vo.setMultiUpdateList(updateList);
            vo.setMultiDeleteList(deleteList);				
			
			dbDao.multiCostCode(vo);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse; // "SUCCESS"
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	


	/**
	 * 헤더가져오기<br>
	 * ESM_COA_003(So Cost Code)화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return CostStructureSoCodeRtnVO
	 * @exception EventException
	 */
	public CostStructureSoCodeRtnVO searchSoCodeList() throws EventException {
		CostStructureSoCodeRtnVO returnVal = new CostStructureSoCodeRtnVO();
		DBRowSet rowSet2 = null;
		StringBuffer headerCode = new  StringBuffer();
		StringBuffer headerText = new  StringBuffer();
		try {
			rowSet2 = dbDao.getVariableHeader();
			//header rowset을 String으로 가공
			int total = rowSet2.getRowCount();

			while(rowSet2.next()){
				headerCode.append(rowSet2.getString("code"));
				headerText.append(rowSet2.getString("name"));
				if(--total != 0){
					headerCode.append("|");
					headerText.append("|");
				}
			}
			
			returnVal.setHeaderCode(headerCode.toString());
			returnVal.setHeaderText(headerText.toString());

			return returnVal;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_003(So Cost Code)화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param CostStructureConditionVO vo
	 * @param String userId
	 * @return CostStructureSoCodeRtnVO
	 * @exception EventException
	 */
	public CostStructureSoCodeRtnVO searchSoCodeList(CostStructureConditionVO vo, String userId) throws EventException {
		CostStructureSoCodeRtnVO returnVal = new CostStructureSoCodeRtnVO();
		
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet2 = null;
		
		StringBuffer headerCode = new  StringBuffer();
		StringBuffer headerText = new  StringBuffer();
		
		try {
			rowSet = dbDao.searchSoCodeList(vo, userId);	
			returnVal.setRowSet(rowSet);
			
			if("".equals(vo.getFHeaderCode()) || vo.getFHeaderCode()==null) {
				rowSet2 = dbDao.getVariableHeader();
			
				int total = rowSet2.getRowCount();	
				while(rowSet2.next()){
					headerCode.append(rowSet2.getString("code"));
					headerText.append(rowSet2.getString("name"));
					if(--total != 0){
						headerCode.append("|");
						headerText.append("|");
					}
				}
				returnVal.setHeaderCode(headerCode.toString());
				returnVal.setHeaderText(headerText.toString());
			}else{
				returnVal.setHeaderCode(vo.getFHeaderCode());
				returnVal.setHeaderText(vo.getFHeaderText());
			}
			return returnVal;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_003(So Cost Code)화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchSoCodeListVO vo
	 * @param SearchSoCodeListVO[] vos
	 * @param String userId
	 * @exception EventException
	 */
	public void multiSoCode(SearchSoCodeListVO vo, SearchSoCodeListVO[] vos, String userId) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		List saveList = new ArrayList();
		List saveList2 = new ArrayList();
		String[] hdCdArr = null;
				
		try {
			hdCdArr = (vo.getHashAttribute("f_header_code")[0]).replace('|', ',').split(","); // 가변컬럼명
			if(vos.length > 0){
				HashMap<String, String> param = null;
				HashMap<String, String> param2 = null;
				
                for(int i = 0 ; i < vos.length ; i++){
                	if(vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("U")) {
	                	//query parameter
	                    param = vos[i].getColumnValues();
	                    param.put("user_id"   , userId);
	                    
	                    // flag 값을 Y/N으로 변경한다.
	                    param.put("bkg_full_soc_cgo_flg"   , Utils.change10ToYN(vos[i].getBkgFullSocCgoFlg()));
                    	param.put("bkg_mcgo_flg"		   , Utils.change10ToYN(vos[i].getBkgMcgoFlg()));
                    	param.put("bkg_rev_mcgo_flg"	   , Utils.change10ToYN(vos[i].getBkgRevMcgoFlg()));
                    	param.put("spcl_cgo_dg_flg"		   , Utils.change10ToYN(vos[i].getSpclCgoDgFlg()));
                    	param.put("spcl_cgo_bb_flg"		   , Utils.change10ToYN(vos[i].getSpclCgoBbFlg()));
                    	param.put("spcl_cgo_awk_flg"	   , Utils.change10ToYN(vos[i].getSpclCgoAwkFlg()));
                    	param.put("spcl_cgo_rf_flg"		   , Utils.change10ToYN(vos[i].getSpclCgoRfFlg()));
                    	param.put("delt_flg"			   , Utils.change10ToYN(vos[i].getDeltFlg()));
                    	param.put("inlnd_expn_use_flg"     , Utils.change10ToYN(vos[i].getInlndExpnUseFlg()));
                    	param.put("inlnd_tml_expn_calc_flg", Utils.change10ToYN(vos[i].getInlndTmlExpnCalcFlg()));
                    	param.put("ocn_fdr_expn_use_flg"   , Utils.change10ToYN(vos[i].getOcnFdrExpnUseFlg()));
                    	
                    	saveList.add(param);
//                    	log.debug("saveList===" + saveList.toString());
                    	// 가변 컬럼에 해당하는 값을 대입한다..
                    	for(int k = 0 ; k < hdCdArr.length ; k++){
                    		
                    		param2 = new HashMap();
                    		param2.put("cost_act_grp_cd", hdCdArr[k]);  // 가변 컬럼 코드값
                    		param2.put("coa_cost_src_cd", vos[i].getCoaCostSrcCd());
                    		param2.put("cost_aply_flg", Utils.change10ToYN( vo.getHashAttribute(hdCdArr[k].toLowerCase())[i])); //가변컬럼 value
                    		param2.put("user_id", userId);
                    		                    		
                    		saveList2.add(param2);                    		
                    	}
                    }                 
                }
            }			
            vo.setMultiSaveList(saveList);
            vo.setMultiSaveList2(saveList2);
			
			dbDao.multiSoCodeSrcAcct(vo);
			dbDao.multiSoCodeCostMapg(vo);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

		
	
//	/**
//	 * 멀티 이벤트 처리<br>
//	 * ESM_COA_014 화면에 대한 멀티 이벤트 처리<br>
//	 * 
//	 * @param e ESM_COA_016Event
//	 * @return EventResponse ESM_COA_016EventResponse
//	 * @exception EventException
//	 */
//	/*
//	public EventResponse createUnitCost(Event e) throws EventException {
//		log.debug("\n ### createUnitCost");
//		// PDTO(Data Transfer Object including Parameters)
//		ESM_COA_108Event event = (ESM_COA_108Event) e;
//
//		try {
//			// 비동기 생성 실행
//			// -----------------------------------------------
//			String cm_uc_cd = "";
//			String cost_create_flag = "";
//
//			// 해당년도 상태 만들기
//			// -----------------------------------------------
//			dbDao.addCOA_UT_COST_CRE_STS(event);
//			// -----------------------------------------------
//
//			for (int j = 0; j < event.getObject("ibflag").length; j++) {
//				cm_uc_cd = event.getObject("cm_uc_cd")[j];
//				event.setAttribute("cm_uc_cd",cm_uc_cd);
//				cost_create_flag = event.getObject("cost_create_flag")[j];
//
//				log.debug("\n ### cm_uc_cd: "+cm_uc_cd);
//				log.debug("\n ### cost_create_flag: "+cost_create_flag);
//				
//				// 20070304 현재 5개 로직 적용 
//				if ("CVFS".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// CVFS|Full Steve
//					eaiDao.sendFullSteve(event);
//				} else if ("CVFT".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// CVFT|Full Trans
//					eaiDao.sendFulTrans(event);
//				} else if ("DMDT".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// DMDT|DEM/DET
////				} else if ("3PTB".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
////					// 3PTB|3rd Party Billing
//				} else if ("MTRP".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// MTRP|MT Repo. Cost
//					//
//				} else if ("EQHD".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// EQHD|EQ Holding Cost
//				} else if ("AGTC".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// AGTC|Agt Commission
//				} else if ("POCN".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// Port Charge/Canal Fee
//				} else if ("VVBK".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// Bunker Fee
//					eaiDao.sendBunkerFee(event);
//				} else if ("OWDH".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// Own_Daily-Hire
//					eaiDao.sendOwnDailyHire(event);
//				} else if ("CHDH".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// CHDH|Chartered_Daily-Hire
//					eaiDao.sendCharteredDailyHire(event);
//				} else if ("EQBA".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// EQBA|EQBalance
//					eaiDao.sendEQBalance(event);
//				} else if ("EMUA".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// EQUIPMENT MANAGEMENT UNIT
//				} else if ("SMUA".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// SLOT MANAGEMENT UNIT
//				} else if ("ABCA".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// ABC/STP Cost
//					eaiDao.sendAbcStpCost(event);
//				} else if ("TMNL".equals(cm_uc_cd) && "1".equals(cost_create_flag)) {
//					// Own Terminal Pricing
//				} else if("RPBC".equals(cm_uc_cd) && "1".equals(cost_create_flag)){
//					//RPBC|	Average Revenue Creation
//					eaiDao.sendAverageRevenue(event);
//				}
//
//			}
//			// -----------------------------------------------
//
//			return null;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage());
//		}
//	}
//	*/
//
//	/**
//	 * 비용 생성(조회, OP관련비용) 조회 이벤트 처리<br>
//	 * ESM_COA_108 화면
//	 * 
//	 * @param e
//	 *            ESM_COA_108Event
//	 * @return EventResponse ESM_COA_0139EventResponse
//	 * @exception EventException
//	 */
//	/*
//	public EventResponse searchCostStructure108List(Event e) throws EventException {
//		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		ESM_COA_108Event event=(ESM_COA_108Event)e;
//	
//		try {
//			rowSet=dbDao.searchCostStructure108List(event);
//			return new ESM_COA_108EventResponse(rowSet,"SUCCESS");
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
//	*/
//	
//	/**
//	 * 비용 생성(조회, OP관련비용) 멀티 이벤트 처리<br>
//	 * ESM_COA_108 화면
//	 * 
//	 * @param e
//	 *            ESM_COA_108Event
//	 * @return EventResponse ESM_COA_0139EventResponse
//	 * @exception EventException
//	 */
//	/*
//	public EventResponse multiCostStructure108(Event e) throws EventException {
//		ESM_COA_108Event event=(ESM_COA_108Event)e;
//		try {
//			// 해당년도 상태 만들기 - 코드가 없으면 insert 한다.
//			// -----------------------------------------------
//			dbDao.addCOA_UT_COST_CRE_STS(event);
//			// -----------------------------------------------
//
//			dbDao.multiCostStructure108(event);
//			return null;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
//	*/	
//
//	/**
//	 * Container Type Size를 리턴해준다.
//	 * 	
//	 * @param e ESM_COA_108Event
//	 * @return boolean 실행결과
//	 * @exception EventException
//	 */
//	public String searchContainerTpSz() throws EventException{
//		String conTS = "";
//		try {
//			conTS = dbDao.getContainerType();
//		} catch(DAOException de){
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//		return conTS;
//	}
//
//	
//	/**
//	 * COA 업무 시나리오 마감작업<br>
//	 * CostStructure업무 시나리오 종료시 관련 내부객체 해제<br>
//	 */
//	public void doEnd() {
//		dbDao = null;
//	}
//	
//	/**
//	 * 
//	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
//	 * @param msg 
//	 * @return
//	 * @throws EventException 
//	 */
//	public void receiveFullSteve(String msg) throws EventException {
//		log.debug("### receiveFullSteve :" + msg);
//
//		try {
//			if(dbDao.createFullSteve(msg) == -1) {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//			} else {
//				msg = msg + "|cost_cre_sts_cd:C"; // 완료
//			}
//			dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			try {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//				dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//				throw new EventException(de.getMessage());
//			} catch (DAOException dex) {
//				log.error("err " + de.toString(), dex);
//				throw new EventException(de.getMessage());
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * 주의 : 
//	 * @param msg 
//	 * @return
//	 * @throws EventException 
//	 */
//	public void receiveOwnDailyHire(String msg) throws EventException {
//		log.debug("### receiveOwnDailyHire :" + msg);
//	
//		try {
//			dbDao.createOwnDailyHire(msg);
//	
//			msg = msg + "|cost_cre_sts_cd:C"; // 완료
//			dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			try {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//				dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//				throw new EventException(de.getMessage());
//			} catch (DAOException dex) {
//				log.error("err " + de.toString(), dex);
//				throw new EventException(de.getMessage());
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * 주의 : 
//	 * @param msg 
//	 * @return
//	 * @throws EventException 
//	 */
//	public void receiveAbcStpCost(String msg) throws EventException {
//		log.debug("### receiveAbcStpCost :" + msg);
//
//		try {
//			dbDao.createAbcStpCost(msg);
//
//			msg = msg + "|cost_cre_sts_cd:C"; // 완료
//			dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			try {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//				dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//				throw new EventException(de.getMessage());
//			} catch (DAOException dex) {
//				log.error("err " + de.toString(), dex);
//				throw new EventException(de.getMessage());
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
//	 * @param msg String - JMS Queue로부터 얻은 메세지
//	 * @return
//	 * @throws EventException 
//	 */
//	public void receiveCharteredDailyHire(String msg) throws EventException {
//		log.debug("### receiveCharteredDailyHire :" + msg);
//
//		try {
//			dbDao.createCharteredDailyHire(msg);
//
//			msg = msg + "|cost_cre_sts_cd:C"; // 완료
//			dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			try {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//				dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//				throw new EventException(de.getMessage());
//			} catch (DAOException dex) {
//				log.error("err " + de.toString(), dex);
//				throw new EventException(de.getMessage());
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
//	 * @param msg String - JMS Queue로부터 얻은 메세지
//	 * @return
//	 * @throws EventException 
//	 */
//	public void receiveEQBalance(String msg) throws EventException {
//		log.debug("### receiveEQBalance :" + msg);
//
//		try {
//			dbDao.createEQBalance(msg);
//
//			msg = msg + "|cost_cre_sts_cd:C"; // 완료
//			dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			try {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//				dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//				throw new EventException(de.getMessage());
//			} catch (DAOException dex) {
//				log.error("err " + de.toString(), dex);
//				throw new EventException(de.getMessage());
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
//	 * @param msg String - JMS Queue로부터 얻은 메세지
//	 * @return
//	 * @throws EventException 
//	 */
//	public void receiveFulTrans(String msg) throws EventException {
//		log.debug("### receiveFulTrans :" + msg);
//	
//		try {
//			if(dbDao.createFulTrans(msg) == -1) {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//			} else {
//				msg = msg + "|cost_cre_sts_cd:C"; // 완료
//			}
//			
//			dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			try {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//				dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//				throw new EventException(de.getMessage());
//			} catch (DAOException dex) {
//				log.error("err " + de.toString(), dex);
//				throw new EventException(de.getMessage());
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
//	 * @param msg String - JMS Queue로부터 얻은 메세지
//	 * @return
//	 * @throws EventException 
//	 */
//	public void receiveBunkerFee(String msg) throws EventException {
//		log.debug("### receiveFulTrans :" + msg);
//
//		try {
//			dbDao.createBunkerFee(msg);
//			msg = msg + "|cost_cre_sts_cd:C"; // 완료
//			
//			dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			try {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//				dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//				throw new EventException(de.getMessage());
//			} catch (DAOException dex) {
//				log.error("err " + de.toString(), dex);
//				throw new EventException(de.getMessage());
//			}
//		}
//	}
//	
//	/**
//	 * 
//	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
//	 * @param msg String - JMS Queue로부터 얻은 메세지
//	 * @return
//	 * @throws EventException 
//	 */
//	public void receiveAverageRevenue(String msg) throws EventException {
//		log.debug("### receiveAverageRevenue :" + msg);
//
//		try {
//			if(dbDao.createAverageRevenue(msg) == -1) {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//			} else {
//				msg = msg + "|cost_cre_sts_cd:C"; // 완료
//			}
//			
//			dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			try {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//				dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//				throw new EventException(de.getMessage());
//			} catch (DAOException dex) {
//				log.error("err " + de.toString(), dex);
//				throw new EventException(de.getMessage());
//			}
//		}
//	}
//	
//	
//	/**
//	 * 
//	 * 주의 : Receive JMS Queue 방식 사용 (JMS Inbound)
//	 * @param msg 
//	 * @return
//	 * @throws EventException 
//	 */
//	public void modifyCOA_UT_COST_CRE_STS(String msg) throws EventException {
//		log.debug("### modifyCOA_UT_COST_CRE_STS :" + msg);
//
//		try {
//			msg = msg + "|cost_cre_sts_cd:P"; // 처리중
//			dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			try {
//				msg = msg + "|cost_cre_sts_cd:E"; // 에러발생 
//				dbDao.modifyCOA_UT_COST_CRE_STS(msg);
//				throw new EventException(de.getMessage());
//			} catch (DAOException dex) {
//				log.error("err " + de.toString(), dex);
//				throw new EventException(de.getMessage());
//			}
//		}
//	}
//	
//	/**
//	 * 조회 이벤트 처리<br>
//	 * ESM_COA_138 화면에 대한 조회 이벤트 처리<br>
//	 * 
//	 * @param e ESM_COA_138Event
//	 * @return EventResponse ESM_COA_138EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchList(Event e) throws EventException{
//		   EventResponse response = null;
//		   
//	try {
//		if(e.getEventName().equals("ESM_COA_138Event")){
//			// PDTO(Data Transfer Object including Parameters)
//			ESM_COA_138Event event = (ESM_COA_138Event) e;	
//			DBRowSet rowSet=dbDao.searchList(event);
//			response = new ESM_COA_138EventResponse(rowSet,"SUCCESS");
//			}
//			return response;
//			} catch (DAOException de) {
//				log.error("err "+de.toString(),de);
//				throw new EventException(de.getMessage());
//				}
//			} 
//	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0138 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<InqOffice0138VO>
	 * @exception EventException
	 */
	public List<InqOffice0138VO> searchInqOffice0138List(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchInqOffice0138List(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * Feeder Term<br>
	 * ESM_COA_0139 화면
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostStructure0139ListVO>
	 * @exception EventException
	 */
	public List<SearchCostStructure0139ListVO> searchCostStructure0139List(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchCostStructure0139List(searchConditionVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CoaTrnsFdrTermVO[] coaTrnsFdrTermVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostStructure0139(CoaTrnsFdrTermVO[] coaTrnsFdrTermVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaTrnsFdrTermVO> insertupdateVoList = new ArrayList<CoaTrnsFdrTermVO>();			
			List<CoaTrnsFdrTermVO> deleteVoList = new ArrayList<CoaTrnsFdrTermVO>();
			
			for ( int i=0; i<coaTrnsFdrTermVO .length; i++ ) {
				if ( coaTrnsFdrTermVO[i].getIbflag().equals("I")){
					 coaTrnsFdrTermVO[i].setCreUsrId(account.getUsr_id());
					 coaTrnsFdrTermVO[i].setUpdUsrId(account.getUsr_id());
					 insertupdateVoList.add(coaTrnsFdrTermVO[i]);
				} else if ( coaTrnsFdrTermVO[i].getIbflag().equals("U")){
					coaTrnsFdrTermVO[i].setUpdUsrId(account.getUsr_id());									
					insertupdateVoList.add(coaTrnsFdrTermVO[i]);
				} else if ( coaTrnsFdrTermVO[i].getIbflag().equals("D")){
					deleteVoList.add(coaTrnsFdrTermVO[i]);
				}
			}
			
			if ( insertupdateVoList.size() > 0 ) {
				dbDao.modifyCostStructure0139(insertupdateVoList);
			}			
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCostStructure0139(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCostStructure0140ListVO searchCostStructure0140List
	 * @param SearchConditionVO searchCondition
	 * @return List<SearchCostStructure0140ListVO>
	 * @exception EventException
	 */
	public List<SearchCostStructure0140ListVO> searchCostStructure0140List(SearchCostStructure0140ListVO searchCostStructure0140List
			                                                              ,SearchConditionVO searchCondition) throws EventException {
		try {
			return dbDao.searchCostStructure0140List(searchCostStructure0140List, searchCondition);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CoaTrnsTermCalcVO[] coaTrnsTermCalcVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostStructure0140(CoaTrnsTermCalcVO[] coaTrnsTermCalcVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaTrnsTermCalcVO> insertupdateVoList = new ArrayList<CoaTrnsTermCalcVO>();			
			List<CoaTrnsTermCalcVO> deleteVoList = new ArrayList<CoaTrnsTermCalcVO>();
			for ( int i=0; i<coaTrnsTermCalcVO .length; i++ ) {
				if ( coaTrnsTermCalcVO[i].getIbflag().equals("I")||coaTrnsTermCalcVO[i].getIbflag().equals("U")){
					coaTrnsTermCalcVO[i].setCreUsrId(account.getUsr_id());
					coaTrnsTermCalcVO[i].setUpdUsrId(account.getUsr_id());
					insertupdateVoList.add(coaTrnsTermCalcVO[i]);
				} else if ( coaTrnsTermCalcVO[i].getIbflag().equals("D")){
					deleteVoList.add(coaTrnsTermCalcVO[i]);
				}
			}
			
			if ( insertupdateVoList.size() > 0 ) {
				dbDao.modifyCostStructure0140(insertupdateVoList);
			}			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCostStructure0140(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @return HashMap
	 * @exception EventException
	 */	
	
	public HashMap searchSoCode0160List() throws EventException {
		try {
			HashMap<String,String> returnVal = new HashMap();
			String headerCode = "";
			String headerText = "";

			DBRowSet rowSet = dbDao.getVariableHeader2();
        	if(rowSet != null){
				int total = rowSet.getRowCount();
				while(rowSet.next()){
					headerCode = headerCode + rowSet.getString("code");
					headerText = headerText + rowSet.getString("name");
					if(--total != 0){
						headerCode = headerCode + "|";
						headerText = headerText + "|";
					}
				}
				returnVal.put("headerCode", headerCode);
				returnVal.put("headerText", headerText);
				return returnVal;
        	} else { 
			  }  
			return returnVal;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSoCode0160ListVO searchSoCode0160ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @param GetVariableheader2VO variableheader2VO
	 * @return SearchSoCode0160ListVO
	 * @exception EventException
	 */	

	public SearchSoCode0160ListVO searchSoCode0160List(SearchSoCode0160ListVO searchSoCode0160ListVO, SearchConditionVO searchConditionVO, GetVariableheader2VO variableheader2VO) throws EventException {
		
		try {
			SearchSoCode0160ListVO retVo = new SearchSoCode0160ListVO();

			retVo = dbDao.searchSoCode0160List(searchSoCode0160ListVO, searchConditionVO, variableheader2VO);

			return retVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param vo GetVariableheader2VO
	 * @param vos CoaAgmtRstrMgmtConditionVO[]
	 * @param SearchConditionVO condVo
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSoCode0160(GetVariableheader2VO vo, CoaAgmtRstrMgmtConditionVO[] vos, SearchConditionVO condVo, SignOnUserAccount account) throws EventException{
		try{			
			String headerCode = vo.getCode();			
			headerCode = headerCode.replace('|', ',');
			String[] headerArr = headerCode.split(",");			
			

			List<HashMap<String, String>> createList = new ArrayList<HashMap<String, String>>();	     
			String[] checkArr = null; //각 COST_ACT_GRP_CD에 대한 checkbox값
			String coa_cost_src_cd = ""; //현재 coa_cost_src_cd
            
            if(vos.length > 0){
                for(int i = 0 ; i < vos.length ; i++){
                    for (int k = 0; k < headerArr.length; k++) {
                    	
						coa_cost_src_cd = headerArr[k];
						checkArr = vo.getHashAttribute(coa_cost_src_cd);
						String chkVal = Utils.change10ToYN(checkArr[i]);                    	
                    	
                        //query parameter
                        HashMap<String, String> param = new HashMap<String, String>();		                                            
                        param.put("loc_delt_flg", Utils.change10ToYN(vos[i].getLocDeltFlg())); 
                        param.put("loc_grp_tp_cd", vos[i].getLocGrpTpCd());
                        
						if(vos[i].getN1stNodCd().equals("")){
							param.put("n1st_nod_cd", "  ");
						}else{
							param.put("n1st_nod_cd", vos[i].getN1stNodCd());
						}                        

						if(vos[i].getN2ndNodCd().equals("")){
							param.put("n2nd_nod_cd", "  ");
						}else{
							param.put("n2nd_nod_cd", vos[i].getN2ndNodCd());
						} 
						
						
						if(vos[i].getN3rdNodCd().equals("")){
							param.put("n3rd_nod_cd", "  ");
						}else{
							param.put("n3rd_nod_cd", vos[i].getN3rdNodCd());
						} 
						
						if(vos[i].getN4thNodCd().equals("")){
							param.put("n4th_nod_cd", "  ");
						}
						else{
							param.put("n4th_nod_cd", vos[i].getN4thNodCd());
						} 						
												
						param.put("coa_cost_src_cd" , headerArr[k]);
						param.put("cost_src_use_flg", chkVal);						
						param.put("upd_usr_id", account.getUsr_id());   			
                        createList.add(param);

                    }
                }
            }               
            vo.setMultiCreateList(createList);		
			
			//[DB 실행]
			dbDao.modifySoCode0160(vo);

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }                
	}	

	
	/**
	 *Sheet1의 테이블의 컬럼 목록을 조회(NODE, LINK))<br>
	 * 
	 * @param String fTableName
	 * @return List<TableColumnVO>
	 * @exception EventException
	 */
	public List<TableColumnVO> searchCostStructure0137List(String fTableName ) throws EventException {
		try {
			return dbDao.searchCostStructure0137List(fTableName);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * NODE,LINK 단가 조회<br>
	 * 
	 * @param String fTableName
	 * @param TableColumnVO[] tableColumnVOs
	 * @return List<NodLnkCostCodeVO>
	 * @exception EventException
	 */
	public List<NodLnkCostCodeVO> searchCostStructure0137List2(String fTableName, TableColumnVO[] tableColumnVOs) throws EventException {
		try {
			return dbDao.searchCostStructure0137List2( fTableName,  tableColumnVOs);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * NODE, LINK단가 입력/수정/삭제<br>
	 * 
	 * @param String fTableName
	 * @param NodLnkCostCodeVO[] nodLnkCostCodeVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostStructure0137(String fTableName, NodLnkCostCodeVO[] nodLnkCostCodeVOs, SignOnUserAccount account) throws EventException{
		try {
			List<NodLnkCostCodeVO> mergeVoList = new ArrayList<NodLnkCostCodeVO>();
			List<NodLnkCostCodeVO> deleteVoList = new ArrayList<NodLnkCostCodeVO>();
			for ( int i=0; i<nodLnkCostCodeVOs .length; i++ ) {
				if ( nodLnkCostCodeVOs[i].getIbflag().equals("I")){
					nodLnkCostCodeVOs[i].setCreUsrId(account.getUsr_id());
					nodLnkCostCodeVOs[i].setUpdUsrId(account.getUsr_id());
					mergeVoList.add(nodLnkCostCodeVOs[i]);
				} else if ( nodLnkCostCodeVOs[i].getIbflag().equals("U")){
					nodLnkCostCodeVOs[i].setCreUsrId(account.getUsr_id());
					nodLnkCostCodeVOs[i].setUpdUsrId(account.getUsr_id());
					mergeVoList.add(nodLnkCostCodeVOs[i]);
				} else if ( nodLnkCostCodeVOs[i].getIbflag().equals("D")){
					deleteVoList.add(nodLnkCostCodeVOs[i]);
				}
			}
			
			if ( mergeVoList.size() > 0) {
				dbDao.modifyCostStructure0137(fTableName, mergeVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCostStructure0137(fTableName, deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}		
}