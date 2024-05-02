/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SettlementProcessBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.04 민정호
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.SltHirTgtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoEstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoSettlementConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration.SettlementProcessDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoLoadingVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.MvntEvntDtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlTgtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlStsVO;
import com.hanjin.syscommon.common.table.JooStlVvdVO;

/**
 * ALPS-Settlementprocess Business Logic Basic Command implementation<br>
 * - ALPS-Settlementprocess에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jungho Min
 * @see JOOCommonEventResponse,JOOFindCodeAndCheckBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SettlementProcessBCImpl extends BasicCommandSupport implements SettlementProcessBC {

	// Database Access Object
	private transient SettlementProcessDBDAO dbDao = null;

	/**
	 * JOOFindCodeAndCheckBCImpl 객체 생성<br>
	 * JOOFindCodeAndCheckDBDAO를 생성한다.<br>
	 */
	public SettlementProcessBCImpl() {
		dbDao = new SettlementProcessDBDAO();
	}

    /**
     * Estimation 마감여부를 check한다.
     * @param JooCodeParamVO jooCodeParamVO
     * @return JooCodeInfoVO
     * @throws EventException
     */
    public JooCodeInfoVO searchCheckEstmClz(JooCodeParamVO jooCodeParamVO) throws EventException {
        try {
            return dbDao.searchCheckEstmClz(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Estimation Closing Flag", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Estimation Closing Flag", "Retrieve"}).getUserMessage(), ex);
        }
    }
    
	/**
	 * 추정결과테이블에서 조건에 해당하는 Trade코드List를 조회한다.
	 * @param JoEstmConditionVO estmConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchTradeCodeListEstm(JoEstmConditionVO estmConditionVO) throws EventException {
		try {
			return dbDao.searchTradeCodeListEstm(estmConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * 추정결과테이블에서 조건에 해당하는 Rlane코드List를 조회한다.
	 * @param JoEstmConditionVO estmConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchRlaneCodeListEstm(JoEstmConditionVO estmConditionVO) throws EventException {
		try {
			return dbDao.searchRlaneCodeListEstm(estmConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Rlane Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Rlane Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 추정결과테이블에서 조건에 해당하는 Carrier코드List를 조회한다.
	 * @param JoEstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchCarrierCodeListEstm(JoEstmConditionVO estmConditionVO) throws EventException {
		try {
			return dbDao.searchCarrierCodeListEstm(estmConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}	
	
    /**
     * JO Target Creation and Basic Slot Hire Settlement 정보를 조회한다. 
     * 
     * @param SettlementConditionVO settlementConditionVO
     * @returnType List<SltHirTgtVO>
     * @throws EventException
     */
    public List<SltHirTgtVO> searchJointOperationAccrualList(JoSettlementConditionVO settlementConditionVO) throws EventException {
        try {
            return dbDao.searchJointOperationAccrualList(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }	
    
    /**
     * JO Target Creation and Basic Slot Hire Settlement 페이지 개수 정보를 조회한다. 
     * 
     * @param SettlementConditionVO settlementConditionVO
     * @returnType SltHirTgtVO
     * @throws EventException
     */
    public SltHirTgtVO searchJointOperationAccrualTotal(JoSettlementConditionVO settlementConditionVO) throws EventException {
        try {
            return dbDao.searchJointOperationAccrualTotal(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }	    
    
    /**
     * 
     * JO Target Creation and Basic Slot Hire Settlement을 [Save]합니다.
     *
     * @param SltHirTgtVO[] sltHirTgtVOs
     * @param JoSettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageJointOperationAccrual( SltHirTgtVO[] sltHirTgtVOs, JoSettlementConditionVO settlementConditionVO,  SignOnUserAccount signOnUserAccount) throws EventException{
 		List<SltHirTgtVO> list = null;    	
 		JoLoadingVO joLoadingVO = new JoLoadingVO();
 		StlTgtVO stlTgtVO = new StlTgtVO();
    
    	try {    		        	
 			list = new ArrayList<SltHirTgtVO>();
 			
 			for (int i=0; i < sltHirTgtVOs.length; i++){
 				list.add(sltHirTgtVOs[i]); 				
 			}
 			
 			String ibFlag = "";
 			int stlVvdSeq = 0;
 			String revYrmon = "";
 			String revYrmonSeq = ""; 			
 			String joFshFlg = "";
 			String joFshFlg2 = ""; 			
 			String acctYrmon = ""; 			
 			String revSeq = ""; 		 	
 			String enblTgt = "Y"; 	 			
 			 			
 			//update도 금액등이 변경될 수 있으므로 체크할 필요 있음
 			for (int i=0; i < list.size(); i++){ 				
 				ibFlag = list.get(i).getIbflag(); 				
 				stlVvdSeq = Integer.parseInt(list.get(i).getStlVvdSeq());
 				joFshFlg = list.get(i).getJoFshFlg();
 				acctYrmon = list.get(i).getAcctYrmon(); 		
 				joFshFlg2 = list.get(i).getJoFshFlg2();
 				
 				
 				if("1".equals(joFshFlg2) && "0".equals(joFshFlg)){
 					enblTgt = dbDao.searchEnblTgt( list.get(i).getRevYrmon(), list.get(i).getRevYrmonSeq(),revSeq); 					 					
 				}
 				
				if("Y".equals(enblTgt)){ 				
	 				if("U".equals(ibFlag) && "0".equals(joFshFlg) && "999912".equals(acctYrmon)){
	 					dbDao.deleteSettlementSltTgt(list.get(i));
	 					
	 		 			stlTgtVO.setRevYrmon(list.get(i).getRevYrmon());
	 		 			stlTgtVO.setRevYrmonSeq(list.get(i).getRevYrmonSeq());
	 		 			stlTgtVO.setRevSeq("");
	 					
	 					dbDao.deleteStlTgt(stlTgtVO);
	 				}else{
			 				if ("U".equals(ibFlag) && stlVvdSeq > 0){
			 					list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
			 					dbDao.modifySettlementSltTgt(list.get(i));
			 				}else if ("U".equals(ibFlag) && stlVvdSeq == 0){
			 					
			 	 				joLoadingVO.setTrdCd(list.get(i).getTrdCd());
			 	 				joLoadingVO.setRlaneCd(list.get(i).getRlaneCd());
			 	 				joLoadingVO.setVslCd(list.get(i).getVslCd());
			 	 				joLoadingVO.setSkdVoyNo(list.get(i).getSkdVoyNo());
			 	 				joLoadingVO.setSkdDirCd(list.get(i).getSkdDirCd());
			 	 				
			 					revYrmon = dbDao.searchRevYrmon(joLoadingVO);
			 					revYrmonSeq = dbDao.searchRevYrmonSeq(revYrmon); 					
			 					 					
			 					list.get(i).setRevYrmon(revYrmon);
			 					list.get(i).setRevYrmonSeq(revYrmonSeq); 					
			 					list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
			 					dbDao.addSettlementSltTgt(list.get(i));
			 				}
	 				}
				}
 			} 						
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[] {"JOO Slot Hire", "SAVE" }).getMessage(), ex);
		}    	
    }    
    
    /**
     * FNS_JOO_0104: Retrieve
     * ROB 컨테이너 Summary List를 Retrieve 합니다.<br>
     *  
     * @param TdrLoadVO tdrLoadVO
     * @param SignOnUserAccount signOnUserAccount
     * @param String gubun
     * @return  List<JoLoadingVO>
     * @throws EventException 
     */
    public  List<JoLoadingVO> searchRobSummaryList(TdrLoadVO tdrLoadVO, SignOnUserAccount signOnUserAccount, String gubun) throws EventException {    	
    	List<JoLoadingVO> list = null;    	
    	
    	
    	try {
//    		String vvd = "";
//    		String pass = "";
    		list =  dbDao.searchRobTotal(tdrLoadVO, gubun);
    		
//    		for(int i=0; i<list.size(); i++){
//    			vvd = list.get(i).getVslCd() + list.get(i).getSkdVoyNo() + list.get(i).getSkdDirCd();    			
//    			pass = dbDao.searchRobPass(vvd);
//    			
//    			list.get(i).setPass(pass);    			
//    		}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"ROB SUMMARY List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"ROB SUMMARY List", "Retrieve"}).getUserMessage(), ex);
		}
    	
    	return list;
    }
//----------------------------------------------------------------------------------------------------
    /**
     * 
     * Jo Loading 정보를 [Save]합니다.
     *
     * @param JoLoadingVO[] joLoadingVOs
     * @param String rlaneCd
     * @param SignOnUserAccount signOnUserAccount
     * @param String reDivrCd
     * @throws EventException
     */
    public void manageJoLoading(JoLoadingVO[] joLoadingVOs, String rlaneCd,SignOnUserAccount signOnUserAccount, String reDivrCd) throws EventException{
 		List<JoLoadingVO> list = null;    	
 		StlTgtVO stlTgtVO = null;
    
    	try {
    		stlTgtVO = new StlTgtVO();
 			    		    		
 			list = new ArrayList<JoLoadingVO>();
 			
 			for (int i=0; i < joLoadingVOs.length; i++){
 				list.add(joLoadingVOs[i]); 				
 			}
 			
 			String ibFlag = "";
 			String acctYrmon = "";
 			String revYrmon = "";
 			String revYrmonSeq = "";
 			String revSeq = ""; 		
 			String stlTgtFlg = "";
 			String stlTgtFlg2 = ""; 	
 			String enblTgt = "Y"; 			
 			String pass = "NP"; 
 			String trdCd = "";
 	
 	
 			//update도 금액등이 변경될 수 있으므로 체크할 필요 있음
 			for (int i=0; i < list.size(); i++){
 				ibFlag = list.get(i).getIbflag(); 	
 				acctYrmon = list.get(i).getAcctYrmon();
 				revYrmon = list.get(i).getRevYrmon();
 				revYrmonSeq = list.get(i).getRevYrmonSeq(); 				
 				stlTgtFlg = list.get(i).getStlTgtFlg();
 				stlTgtFlg2 = list.get(i).getStlTgtFlg2();
 				pass = list.get(i).getPass();
 				trdCd = list.get(i).getTrdCd();
 				 				 				 				
 				log.debug("ibFlag = "+ibFlag);
 				
 				if("U".equals(ibFlag)){
 					
 					if("Exp".equals(reDivrCd)){ 		 					
	 	 				if("P".equals(pass)){
	 	 					enblTgt = "Y";	
	 	 				}else{ 	 					
	 	 					enblTgt = "N"; 	 					
	 	 				}
 					}else{
 						enblTgt = "Y";
 					}
 					
 	 				if("1".equals(stlTgtFlg2) && "0".equals(stlTgtFlg) && "Y".equals(enblTgt)){
 	 					enblTgt = dbDao.searchEnblTgt(revYrmon,revYrmonSeq,revSeq); 					 					
 	 				} 					
 					 	 				 	 				
 	 				revYrmon = dbDao.searchRevYrmon(list.get(i));
 	 				if(revYrmon == null || "".equals(revYrmon)){
 	 					enblTgt = "N";
 	 				}
 	 				
// 	 				if("Y".equals(enblTgt)){
	 					list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());		
	 					 					 					
	 					if("999912".equals(acctYrmon) && "0".equals(stlTgtFlg)){ 						 						 						
	 						stlTgtVO.setRevYrmon(list.get(i).getRevYrmon());
	 						stlTgtVO.setRevYrmonSeq(list.get(i).getRevYrmonSeq()); 	
	 						stlTgtVO.setRevSeq("");
	 						
	 						dbDao.deleteStlTgt(stlTgtVO);
	 					} 					
	 					
	 					if("Exp".equals(reDivrCd)){ 						
	 						if("".equals(list.get(i).getRevYrmon()) || list.get(i).getRevYrmon() == null){
	 		 					dbDao.deleteJoLoading(list.get(i));
	
	 		 					revYrmon = dbDao.searchRevYrmon(list.get(i));
	 		 					
	 		 					if(revYrmon == null || "".equals(revYrmon)){
	 		 						revYrmon = "999912";
	 		 					}
	 		 					
	 		 					revYrmonSeq = dbDao.searchRevYrmonSeq(revYrmon);	 					
	 		 					list.get(i).setRevYrmon(revYrmon);
	 		 					list.get(i).setRevYrmonSeq(revYrmonSeq);
	 		 					list.get(i).setReDivrCd("E");			// Exp는 'E'
	 		 						 					
	 		 					dbDao.addJoLoading(list.get(i)); 							
	 						}else{
	 							dbDao.modifyJoLoading(list.get(i));
	 						} 						
	 					}
//	 					else{
//	 						if("".equals(list.get(i).getRevYrmon()) || list.get(i).getRevYrmon() == null){ 						
//			 					dbDao.deleteJoRevLoading(list.get(i));
//			 					
//			 					revYrmon = dbDao.searchRevYrmon(list.get(i));
//			 					
//	 		 					if(revYrmon == null || "".equals(revYrmon)){
//	 		 						revYrmon = "999912";
//	 		 					}
//			 					
//			 					revYrmonSeq = dbDao.searchRevYrmonSeq(revYrmon);	 					
//			 					list.get(i).setRevYrmon(revYrmon);
//			 					list.get(i).setRevYrmonSeq(revYrmonSeq);
//			 					list.get(i).setReDivrCd("R");			// Exp는 'R'
//			 								 								 					
//			 					dbDao.addJoRevLoading(list.get(i));
//	 						}else{
//	 							dbDao.modifyJoLoading(list.get(i));
//	 						} 								 					
//	 					}
// 	 				}
 				} 						
 			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[] {"Jo Loading", "SAVE" }).getMessage(), ex);
		}    	
    }          

    /** 
     * Joo Revenue Loading 정보를 [Save]합니다.
     *
     * @param JoLoadingVO[] joLoadingVOs
     * @param TdrLoadVO tdrLoadVO
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageJoRevLoadingMerge(JoLoadingVO[] joLoadingVOs, TdrLoadVO tdrLoadVO,SignOnUserAccount signOnUserAccount) throws EventException{
 		List<JoLoadingVO> list = null;    	
 		StlTgtVO stlTgtVO = null;
    
    	try {
    		stlTgtVO = new StlTgtVO();
 			    		    		
 			list = new ArrayList<JoLoadingVO>();
 			
 			for (int i=0; i < joLoadingVOs.length; i++){
 				list.add(joLoadingVOs[i]); 				
 			}
 			
 			String ibFlag = "";
 			String acctYrmon = "";
 			String revYrmon = "";
 			String revYrmonSeq = "";
 			String revYrmonSeq2 = ""; 		
 			String stlTgtFlg = "";
 			String stlTgtFlg2 = ""; 	
 			String pass = "NP"; 
 			String trdCd = "";
 	
 			String crr = "";
 			String mergeCrr = "";
 			String[] arrCrr = null;
 			String[] arrCarrier = null;
 			String mergeRmk = "";
 	
 			//update도 금액등이 변경될 수 있으므로 체크할 필요 있음
 			for (int i=0; i < list.size(); i++){
 				ibFlag = list.get(i).getIbflag(); 	
 				acctYrmon = list.get(i).getAcctYrmon();
 				revYrmon = list.get(i).getRevYrmon();
 				revYrmonSeq = list.get(i).getRevYrmonSeq(); 				
 				stlTgtFlg = list.get(i).getStlTgtFlg();
 				stlTgtFlg2 = list.get(i).getStlTgtFlg2();
 				pass = list.get(i).getPass();
 				trdCd = list.get(i).getTrdCd();
 				 				 				 				
 				log.debug("ibFlag = "+ibFlag);
 				
 				if("U".equals(ibFlag)){
 	 				
 					list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());		
 					 					 					
 					if("999912".equals(acctYrmon) && "0".equals(stlTgtFlg)){ 						 						 						
 						stlTgtVO.setRevYrmon(list.get(i).getRevYrmon());
 						stlTgtVO.setRevYrmonSeq(list.get(i).getRevYrmonSeq()); 	
 						stlTgtVO.setRevSeq("");
 						
 						dbDao.deleteStlTgt(stlTgtVO);
 					} 					
 					
 					crr = tdrLoadVO.getOprCd();
 					mergeCrr = tdrLoadVO.getMergeCrr();
 					
 					arrCrr = crr.split(",");
 					
 					/*
 					 Carrier : COS, UAC 
 					 Merge : UAC
 					 
 					 arrCrr[] = {COS, UAC}
 					 arrCarrier[] = {UAC, COS} 로 변경( 이렇게 하는 이유는 Merge문에서 에러나서 배열순서를 변경함) 					 
 					 */

 					arrCarrier= new String[arrCrr.length]; 					
 					int j = 1;
 					
 					arrCarrier[0] = mergeCrr;
 					for(int p=0; p<arrCrr.length; p++){
 						if(!mergeCrr.equals(arrCrr[p])){
	 						arrCarrier[j++] = arrCrr[p];
 						}
 					}
 					
 					for(int m=0; m<arrCrr.length; m++){
 						log.debug("arrCarrier[] = "+arrCarrier[m]);
 					}
 				 					
 					mergeRmk = "Merge ["+mergeCrr+"/";
 					
 					for(int k=0; k<arrCrr.length; k++){
 						if(!arrCrr[k].equals(mergeCrr)){
 							mergeRmk = mergeRmk + arrCrr[k]+"/";			 							
 						}
 					}
 				
 					if(!(mergeCrr == null || "".equals(mergeCrr))){
 						list.get(i).setRmk(mergeRmk.substring(0, mergeRmk.length()-1)+"]");	 						 					
 					}
 					
 					for(int c=0; c<arrCarrier.length; c++){
 						list.get(i).setCrrCd(arrCarrier[c]);	 
 						if(!"1".equals(list.get(i).getStlTgtFlg2())){
 							 	 					
 	 	 					if(revYrmon == null || "".equals(revYrmon)){				// Merge에서 Close를 먼저하고 Taget을 선택시에 revYrmon를 구한다.
 	 	 						revYrmon = dbDao.searchRevYrmon(list.get(i));
 	 	 						list.get(i).setRevYrmon(revYrmon);
 	 	 					}
 							
 							dbDao.deleteJoRevLoading(list.get(i));
 						}
 					} 					
 					
 					if("1".equals(list.get(i).getStlTgtFlg2())){
 						revYrmon = list.get(i).getRevYrmon();
 						revYrmonSeq2 = list.get(i).getRevYrmonSeq();
 	 					list.get(i).setRevYrmon(revYrmon);
 					}else{
 	 					revYrmon = dbDao.searchRevYrmon(list.get(i));	 					
 	 					if(revYrmon == null || "".equals(revYrmon)){
 	 						revYrmon = "999912";
 	 					}	 					
 						 					 					 					 				 					
 	 					revYrmonSeq2 = dbDao.searchRevYrmonSeq(revYrmon);	 					
 	 					list.get(i).setRevYrmon(revYrmon);
 						
 					}
 					list.get(i).setReDivrCd("R");			// Revenue 'R'
 				 					
 					for(int k=0; k<arrCarrier.length; k++){
 						if(arrCarrier[k].equals(mergeCrr)){ 	 							 	 							
 							list.get(i).setRevYrmonSeq(revYrmonSeq2);	 	 							
 							list.get(i).setCrrCd(arrCarrier[k]);	 	 							
	 						dbDao.addJoRevLoadingMerge(list.get(i));	 	 										 							
 						}else{ 	 							 	 							
 							revYrmonSeq2 = String.valueOf(Integer.parseInt(revYrmonSeq2)+ 1); 	 							
 							list.get(i).setRevYrmonSeq(revYrmonSeq2);
 							list.get(i).setCrrCd(arrCarrier[k]);
	 						dbDao.addJoRevLoadingMerge(list.get(i));	 	 							
 						}
 					}	 							
 				}	 						 					 						
 			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[] {"Jo Loading", "SAVE" }).getMessage(), ex);
		}    	
    }           
    
    
    /** 
     * Joo Revenue Loading 정보를 [Save]합니다.
     *
     * @param JoLoadingVO[] joLoadingVOs
     * @param TdrLoadVO tdrLoadVO
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */        
    public void manageJoRevLoading(JoLoadingVO[] joLoadingVOs, TdrLoadVO tdrLoadVO,SignOnUserAccount signOnUserAccount) throws EventException{
 		List<JoLoadingVO> list = null;    	
 		StlTgtVO stlTgtVO = null;
    
    	try {
    		stlTgtVO = new StlTgtVO();
 			    		    		
 			list = new ArrayList<JoLoadingVO>();
 			
 			for (int i=0; i < joLoadingVOs.length; i++){
 				list.add(joLoadingVOs[i]); 				
 			}
 			
 			String ibFlag = "";
 			String acctYrmon = "";
 			String revYrmon = "";
 			String revYrmonSeq = "";
 			String stlTgtFlg = "";
 			String stlTgtFlg2 = ""; 	
 			String pass = "NP"; 
 			String trdCd = ""; 	
 			String mergeCrr = "";
 	
 			//update도 금액등이 변경될 수 있으므로 체크할 필요 있음
 			for (int i=0; i < list.size(); i++){
 				ibFlag = list.get(i).getIbflag(); 	
 				acctYrmon = list.get(i).getAcctYrmon();
 				revYrmon = list.get(i).getRevYrmon();
 				revYrmonSeq = list.get(i).getRevYrmonSeq(); 				
 				stlTgtFlg = list.get(i).getStlTgtFlg();
 				stlTgtFlg2 = list.get(i).getStlTgtFlg2();
 				pass = list.get(i).getPass();
 				trdCd = list.get(i).getTrdCd();
 				 				 				 				
 				log.debug("ibFlag = "+ibFlag);
 				
 				if("U".equals(ibFlag)){
 	 				
 					list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());		
 					 					 					
 					if("999912".equals(acctYrmon) && "0".equals(stlTgtFlg)){ 						 						 						
 						stlTgtVO.setRevYrmon(list.get(i).getRevYrmon());
 						stlTgtVO.setRevYrmonSeq(list.get(i).getRevYrmonSeq()); 	
 						stlTgtVO.setRevSeq("");
 						
 						dbDao.deleteStlTgt(stlTgtVO);
 					} 					
 					 					
 					if(!"1".equals(list.get(i).getStlTgtFlg2())){		// 이미 Taget 체크 하면 Update
 						
 	 					if(revYrmon == null || "".equals(revYrmon)){				// Close를 먼저하고 Taget을 선택시에 revYrmon를 구한다.
 	 						revYrmon = dbDao.searchRevYrmon(list.get(i));
 	 						list.get(i).setRevYrmon(revYrmon);
 	 					}
 						 						
 						dbDao.deleteJoRevLoading(list.get(i));	 			
 					}
 					
 					if("1".equals(list.get(i).getStlTgtFlg2())){		// 이미 Taget 체크 하면 Update
	 					revYrmon = list.get(i).getRevYrmon();
	 					revYrmonSeq = list.get(i).getRevYrmonSeq();
 					}else{														// Taget 체크 안하면 Insert
	 					revYrmon = dbDao.searchRevYrmon(list.get(i));	 					
	 					if(revYrmon == null || "".equals(revYrmon)){
	 						revYrmon = "999912";
	 					}	 					
	 					revYrmonSeq = dbDao.searchRevYrmonSeq(revYrmon);	 					
 					}
 					
 					list.get(i).setRevYrmon(revYrmon);
 					list.get(i).setRevYrmonSeq(revYrmonSeq);
 					list.get(i).setReDivrCd("R");			// Exp는 'R'
 					
					if("".equals(mergeCrr) || mergeCrr == null){		// Merge가 없으면 해당 VVD만 Taget,Close저장한다.						
						dbDao.addJoRevLoadingMerge(list.get(i));	 	 
					}
 				}
 			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[] {"Jo Loading", "SAVE" }).getMessage(), ex);
		}    	
    }        
    
    
	/**
	 * TDR Carrier Code 조회, Period, rlane이 조회조건임
	 * @param TdrLoadVO tdrLoadVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchJoRevCarrierCodeString(TdrLoadVO tdrLoadVO) throws EventException {
		try {
			return dbDao.searchJoRevCarrierCodeString(tdrLoadVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}    
    
	/**
	 * JOO_SETTLEMENT를 조회한다.(W/R, PBS, OTH, S/H, OUS RDR, OUS, TDR 공통으로 사용된다.)
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchSettlementList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchSettlementList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * Movement Event Date 리스트 조회한다.
	 * @param MvntEvntDtVO mvntEvntDtVO 
	 * @return List<MvntEvntDtVO>
	 * @exception EventException
	 */
	public List<MvntEvntDtVO> searchMvntEvntDateList(MvntEvntDtVO mvntEvntDtVO) throws EventException {
		try {
			return dbDao.searchMvntEvntDateList(mvntEvntDtVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Movement Event Date", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Movement Event Date", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * Skd Event Date 리스트 조회한다.
	 * @param MvntEvntDtVO mvntEvntDtVO 
	 * @return List<MvntEvntDtVO>
	 * @exception EventException
	 */
	public List<MvntEvntDtVO> searchSkdEvntDatet(MvntEvntDtVO mvntEvntDtVO) throws EventException {
		try {
			return dbDao.searchSkdEvntDatet(mvntEvntDtVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Movement Event Date", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Movement Event Date", "Retrieve"}).getMessage(), ex);
		}
	}	
	
    /**
     *  Movement Event Date을 저장합니다.<br>
     *
     * @param MvntEvntDtVO[] mvntEvntDtVOs
     * @param SignOnUserAccount signOnUserAccount 
     * @throws EventException
     */     
    public void manageMvntEvntDate(MvntEvntDtVO[] mvntEvntDtVOs, SignOnUserAccount signOnUserAccount) throws EventException{
 		List<MvntEvntDtVO> list = null;    	
    
    	try {			    		        	
 			list = new ArrayList<MvntEvntDtVO>();
 			
 			for (int i=0; i < mvntEvntDtVOs.length; i++){
 				list.add(mvntEvntDtVOs[i]); 				
 			}
 			
// 			int iRtn = 0; //Dup Check 조회 후 return 값

 			String ibFlag = "";
 			String cnmvDt = "";

 			for (int i=0; i < list.size(); i++){ 				
 				ibFlag = list.get(i).getIbflag(); 				
 				cnmvDt = list.get(i).getCnmvDt();

				list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
				
				if(!("".equals(cnmvDt) || cnmvDt == null)){
					dbDao.deleteMvntEvntDate(list.get(i));
					dbDao.addMvntEvntDate(list.get(i));
				} 				
 			} 						
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[] {"JOO Slot Hire", "SAVE" }).getMessage(), ex);
		}    	
    }	
    
    /**
     * FNS_JOO_0108: Retrieve
     * D : [FnsJoo0108Event]<br>
     * RDR Load DownLoad by VVD 을  조회 Retrieve 합니다.<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @return List<JoLoadingVO>
     * @throws EventException
     */
    public List<JoLoadingVO> searchTDRDownloadListByLane(TdrLoadVO tdrLoadVO)
            throws EventException {
        try {
            return dbDao.searchTDRDownloadListByLane( tdrLoadVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
    }
    
    /**
     * Settlement Target정보를 조회한다. 
     * 
     * @param SettlementConditionVO settlementConditionVO
     * @returnType List<StlTgtVO>
     * @throws EventException
     */
    public List<StlTgtVO> searchStlTgtList(JoSettlementConditionVO settlementConditionVO) throws EventException {
        try {
            return dbDao.searchStlTgtList(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }	
    
    /**
     * Settlement Target 페이지 개수 정보를 조회한다. 
     * 
     * @param SettlementConditionVO settlementConditionVO
     * @returnType SltHirTgtVO
     * @throws EventException
     */
    public SltHirTgtVO searchStlTgTotaltList(JoSettlementConditionVO settlementConditionVO) throws EventException {
        try {
            return dbDao.searchStlTgtTotalList(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }	    
    
    
    /** 
     * Settlement Target을 [Save]합니다.
     *
     * @param StlTgtVO[] stlTgtVOs
     * @param JoSettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageStlTgt(StlTgtVO[] stlTgtVOs, JoSettlementConditionVO settlementConditionVO,  SignOnUserAccount signOnUserAccount) throws EventException{
 		List<StlTgtVO> list = null;    	
    
    	try {
 			list = new ArrayList<StlTgtVO>();
 			
 			for (int i=0; i < stlTgtVOs.length; i++){
 				list.add(stlTgtVOs[i]); 				
 			}
 			
 			String acctYrmon = "";
 			String revYrmon = "";
 			String revYrmonSeq = ""; 			
 			String revSeq = ""; 			
 			String stlTgtFlg = "";
 			String stlTgtFlg2 = ""; 	
 			String enblTgt = "Y";
 			
 			//update도 금액등이 변경될 수 있으므로 체크할 필요 있음
 			for (int i=0; i < list.size(); i++){
 				
 				acctYrmon = list.get(i).getAcctYrmon();
 				revYrmon = list.get(i).getRevYrmon();
 				revYrmonSeq = list.get(i).getRevYrmonSeq();
 				revSeq = list.get(i).getRevSeq();
 				stlTgtFlg = list.get(i).getStlTgtFlg();
 				stlTgtFlg2 = list.get(i).getStlTgtFlg2();

 				 			
 				if("".equals(acctYrmon) || acctYrmon == null){
 					acctYrmon = "";
 				} 				
 				if("".equals(revSeq) || revSeq == null){
 					revSeq = "";
 				}
 				if("".equals(stlTgtFlg) || stlTgtFlg == null){
 					stlTgtFlg = "0";
 				} 				
 				if("".equals(stlTgtFlg2) || stlTgtFlg2 == null){
 					stlTgtFlg2 = "0";
 				} 	 					
 				 				 				
 				if("D".equals(list.get(i).getIbflag())){		// 삭제 					
 					if(!"".equals(list.get(i).getRevSeq())){
 						dbDao.deleteStlTgt(list.get(i));
 					}
 				}else{
 	 				if("1".equals(stlTgtFlg2) && "0".equals(stlTgtFlg)){
 	 					enblTgt = dbDao.searchEnblTgt(revYrmon,revYrmonSeq,revSeq); 					 					
 	 				}
 					
	 				if("Y".equals(enblTgt)){
						if("".equals(revSeq)){ 				 					
							list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
							list.get(i).setRevEnblFlg("0");					
											
							if("I".equals(list.get(i).getRfScgStlTpCd())){
								list.get(i).setReDivrCd("E");						
							}else if("R".equals(list.get(i).getRfScgStlTpCd())){
								list.get(i).setReDivrCd("R");						
							}
							
		 					if(revYrmon == null || "".equals(revYrmon)){
		 						revYrmon = "999912";
		 					}	 				
	
		 					if(revYrmonSeq == null || "".equals(revYrmonSeq)){
		 						revYrmonSeq = dbDao.searchRevYrmonSeq(revYrmon);
		 						list.get(i).setRevYrmonSeq(revYrmonSeq);
		 					}	 				
							dbDao.addStlTgt(list.get(i));
						}else{
							dbDao.modifyStlTgtClz(list.get(i));
						}
	 				}
 				}
 			} 						
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[] {"JOO Slot Hire", "SAVE" }).getMessage(), ex);
		}    	
    }        
    
    /** 
     * Settlement Target Sublet을 [Save]합니다.
     *
     * @param StlTgtVO[] stlTgtVOs
     * @param JoSettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageStlTgtSublet(StlTgtVO[] stlTgtVOs, JoSettlementConditionVO settlementConditionVO,  SignOnUserAccount signOnUserAccount) throws EventException{
 		List<StlTgtVO> list = null;    	
    
    	try {
 			list = new ArrayList<StlTgtVO>();
 			
 			for (int i=0; i < stlTgtVOs.length; i++){
 				list.add(stlTgtVOs[i]); 				
 			}
 			
 			String ibFlag = "";
 			String acctYrmon = "";
 			String stlTgtFlg = "";
 			String stlClzFlg = "";
 			
 			//update도 금액등이 변경될 수 있으므로 체크할 필요 있음
 			for (int i=0; i < list.size(); i++){ 				
 				ibFlag = list.get(i).getIbflag(); 				
 				acctYrmon = list.get(i).getAcctYrmon();
 				stlTgtFlg = list.get(i).getStlTgtFlg();
 				stlClzFlg = list.get(i).getStlClzFlg(); 				
 				 				
 				log.debug("list.get(i).getRfScgStlTpCd() = "+list.get(i).getRfScgStlTpCd());		//T(TDR), R(RDR), I(User INPUT), Sublet은 Expense만 해당 됨.
 				log.debug("list.get(i).getRevEnblFlg() = "+list.get(i).getRevEnblFlg());
 				log.debug("list.get(i).getRevSeq()"+list.get(i).getRevSeq());
 				
 				if ("U".equals(ibFlag) && "I".equals(list.get(i).getRfScgStlTpCd())
 											   && "1".equals(list.get(i).getRevEnblFlg())
 											   && "0".equals(list.get(i).getRevChk())				// rev_chk 안 된것만 적용(먼저 JOO_STL_TGT에 저장된것을 대상으로 한다.)
 											   ){		// ROB에서만 해당
						list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
						
						list.get(i).setRevEnblFlg("1");							
						dbDao.modifyStlTgt(list.get(i));
						
						list.get(i).setReDivrCd("R");			// Sublet은 Re_divr_cd가 'R'로 처리
						list.get(i).setStlTgtFlg("0");			// Sublet은 Taget이 비선택으로 세팅
						list.get(i).setRfScgStlTpCd("T");  //  Sublet은 RF_SCG_STL_TP_CD가 'T'로 세팅
						list.get(i).setStlRmk("Sublet");
						list.get(i).setFnlBsaQty(list.get(i).getRevBsaQty());
						list.get(i).setFnlBsaSltPrc(list.get(i).getRevBsaSltPrc());
						list.get(i).setCrrCd(list.get(i).getRevCrrCd());
						list.get(i).setRevShwFlg("S");		// rev_shw_flg A:Row Add, C:Row Copy S:Sublet
						dbDao.addStlTgt(list.get(i));					 					
 				}
 				
 				if ("U".equals(ibFlag) && "I".equals(list.get(i).getRfScgStlTpCd())
						   && "1".equals(list.get(i).getN2ndRevEnblFlg())
						   && "0".equals(list.get(i).getN2ndRevChk())								// rev_chk 안 된것만 적용(먼저 JOO_STL_TGT에 저장된것을 대상으로 한다.)
						   ){		// ROB에서만 해당
						list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
						
						list.get(i).setN2ndRevEnblFlg("1");			
						dbDao.modifyStlTgt(list.get(i));
						
						list.get(i).setReDivrCd("R");			// Sublet은 Re_divr_cd가 'R'로 처리
						list.get(i).setStlTgtFlg("0");			// Sublet은 Taget이 비선택으로 세팅
						list.get(i).setRfScgStlTpCd("T");  //  Sublet은 RF_SCG_STL_TP_CD가 'T'로 세팅
						list.get(i).setStlRmk("Sublet");						
						list.get(i).setFnlBsaQty(list.get(i).getN2ndRevBsaQty());
						list.get(i).setFnlBsaSltPrc(list.get(i).getN2ndRevBsaSltPrc());		
						list.get(i).setCrrCd(list.get(i).getN2ndRevCrrCd());
						list.get(i).setRevShwFlg("S");		// rev_shw_flg A:Row Add, C:Row Copy S:Sublet				
						dbDao.addStlTgt(list.get(i));					 					
				}
 				
 				if ("U".equals(ibFlag) && "I".equals(list.get(i).getRfScgStlTpCd())
						   && "1".equals(list.get(i).getN3rdRevEnblFlg())
						   && "0".equals(list.get(i).getN3rdRevChk())								// rev_chk 안 된것만 적용(먼저 JOO_STL_TGT에 저장된것을 대상으로 한다.)
						   ){		// ROB에서만 해당
						list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
						
						list.get(i).setN3rdRevEnblFlg("1");			
						dbDao.modifyStlTgt(list.get(i));
						
						list.get(i).setReDivrCd("R");			// Sublet은 Re_divr_cd가 'R'로 처리
						list.get(i).setStlTgtFlg("0");			// Sublet은 Taget이 비선택으로 세팅	
						list.get(i).setRfScgStlTpCd("T");  //  Sublet은 RF_SCG_STL_TP_CD가 'T'로 세팅
						list.get(i).setStlRmk("Sublet");
						list.get(i).setFnlBsaQty(list.get(i).getN3rdRevBsaQty());
						list.get(i).setFnlBsaSltPrc(list.get(i).getN3rdRevBsaSltPrc());		
						list.get(i).setCrrCd(list.get(i).getN3rdRevCrrCd());						
						list.get(i).setRevShwFlg("S");		// rev_shw_flg A:Row Add, C:Row Copy S:Sublet						
						dbDao.addStlTgt(list.get(i));					 					
				} 				
 			} 						
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[] {"JOO Slot Hire", "SAVE" }).getMessage(), ex);
		}    	
    }         
    
    
	/**
	 * Settlement Target 조회한다.
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @param SignOnUserAccount signOnUserAccount 
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlList(ProcSettlementVO procSettlementVO, SignOnUserAccount signOnUserAccount) throws EventException {
		try {					
			procSettlementVO.setAuthOfcCd(signOnUserAccount.getOfc_cd());			
			return dbDao.searchAddStlList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Settlement Target", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Settlement Target", "Retrieve"}).getUserMessage(), ex);
		}
	}    
	
    /**
     * JO Settlement Status Information정보를 조회한다. 
     * 
     * @param StlStsVO stlStsVO
     * @returnType List<StlStsVO>
     * @throws EventException
     */
    public List<StlStsVO> searchJoSettlementStatusList(StlStsVO stlStsVO) throws EventException {
        try {
            return dbDao.searchJoSettlementStatusList(stlStsVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }			
    
    /**
     * JO Settlement Status Information 페이지 개수 정보를 조회한다. 
     * 
     * @param StlStsVO stlStsVO
     * @returnType StlStsVO
     * @throws EventException
     */
    public StlStsVO searchJoSettlementStatusListTotal(StlStsVO stlStsVO) throws EventException {
        try {
            return dbDao.searchJoSettlementStatusListTotal(stlStsVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }	    
    
 	 /**
 	 * Settlement 저장시에 중복체크를 해서 중복된 데이터가 있으면 user에게 알려주고 없으면 저장한다.
 	 * 적용 ITEM : P/B, W/R, OTH
 	 * 
 	 * @param ProcSettlementVO[] procSettlementVOs
 	 * @param String acctYrmon
 	 * @param SignOnUserAccount signOnUserAccount
 	 * @return List<ProcSettlementVO>
 	 * @throws EventException
 	 */
 	public List<ProcSettlementVO> manageSettlement(ProcSettlementVO[] procSettlementVOs, String acctYrmon, SignOnUserAccount signOnUserAccount) throws EventException{
 		List<ProcSettlementVO> list = null;
 		JooStlVvdVO jooStlVvdVO = null;
 		
 		try { 			
			String currentYrmon = DateTime.getFormatDate(new java.util.Date(), "yyyyMM");											 	
 			if("".equals(acctYrmon) || acctYrmon == null){
 				log.debug("SettlementProcessBCImpl currentYrmon = "+currentYrmon);
 	 			acctYrmon = currentYrmon;			
 			}
 			
 			list = new ArrayList<ProcSettlementVO>();
 			
 			for (int i=0; i < procSettlementVOs.length; i++){
 				list.add(procSettlementVOs[i]);
 				
 				//삭제 먼저 처리한다.
 				if ("D".equals(procSettlementVOs[i].getIbflag())){
 					dbDao.removeSettlement(list.get(i));
 				}
 			}

 			int iRtn = 0; //Dup Check 조회 후 return 값

 			String ibFlag = "";
 			String stlDupFlg= "";	
 			int iDupCnt = 0;
 			String stlVvdSeq = "";
 			String stlSeq = "";
 			String oldStlSeq = ""; 			
			String revYrmon = "";
			String revYrmonSeq = "";
			String revSeq = "";
 			

 			//update도 금액등이 변경될 수 있으므로 체크할 필요 있음
 			for (int i=0; i < list.size(); i++){
 				
 				ibFlag = list.get(i).getIbflag();
 				
 				if ("R".equals(ibFlag) || "D".equals(ibFlag))
 					continue;

 				stlDupFlg = list.get(i).getStlDupFlg();
 				 
 	 			//Other인 경우 Settlement만 조회해서 Dup Check한다.
  				iRtn  = dbDao.searchSettlementDupChk(list.get(i));
 

 				if ("U".equals(ibFlag)){
 					//DupChkFree가 Y인 경우는 Dup check를 하지 않는다.
 					if (!"Y".equals(stlDupFlg)){
 						if (iRtn > 0){
 							list.get(i).setStlDupFlg("Y");
 							iDupCnt++;
 							break;
 						}
 					//Y인 경우도 DUP CHECK해서 DUP이 아니면 N으로 바꿔준다.
 					}else{
 						if (iRtn == 0){
 							list.get(i).setStlDupFlg("N");
 						}
 					}
 					list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
 					dbDao.modifySettlement(list.get(i));
 				}else if ("I".equals(ibFlag)){
 					if (!"Y".equals(stlDupFlg)){
 						if (iRtn > 0){
 							list.get(i).setStlDupFlg("Y");
 							iDupCnt++;
 							break;
 						}
 					}
 					list.get(i).setCreUsrId(signOnUserAccount.getUsr_id());
 					
 						jooStlVvdVO = new JooStlVvdVO(); 						
 						stlVvdSeq = dbDao.searchStlVvdSeq(acctYrmon); 				
 						
 						jooStlVvdVO.setAcctYrmon(acctYrmon);
 						jooStlVvdVO.setStlVvdSeq(stlVvdSeq);
 						jooStlVvdVO.setTrdCd(list.get(i).getTrdCd());
 						jooStlVvdVO.setJoCrrCd(list.get(i).getJoCrrCd());
 						jooStlVvdVO.setRlaneCd(list.get(i).getRlaneCd());
 						jooStlVvdVO.setReDivrCd(list.get(i).getReDivrCd());
 						jooStlVvdVO.setJoStlItmCd(list.get(i).getJoStlItmCd());
 						jooStlVvdVO.setJoMnuNm("M/S");
 						jooStlVvdVO.setVslCd(list.get(i).getVslCd());
 						jooStlVvdVO.setSkdVoyNo(list.get(i).getSkdVoyNo());
 						jooStlVvdVO.setSkdDirCd(list.get(i).getSkdDirCd());
 						jooStlVvdVO.setRevDirCd(list.get(i).getRevDirCd());
 						jooStlVvdVO.setStlBzcPortCd(list.get(i).getStlBzcPortCd());
 						jooStlVvdVO.setBzcPortEtaDt(list.get(i).getUcBssPortEtdDt());
 						jooStlVvdVO.setUcBssPortEtdDt(list.get(i).getUcBssPortEtdDt());
 						jooStlVvdVO.setUpdUsrId(signOnUserAccount.getUsr_id());
 						 						
 						stlSeq = dbDao.searchStlSeq(acctYrmon, stlVvdSeq); 						
 						
 						oldStlSeq = list.get(i).getStlSeq();
 						if("".equals(oldStlSeq) || oldStlSeq == null){
 							oldStlSeq = "0";
 						}
 						 
 						log.debug("old_acct_yrmon= "+list.get(i).getAcctYrmon());
 						log.debug("old_stlVvdSeq= "+list.get(i).getStlVvdSeq()); 						
 						log.debug("old_stlSeq = "+list.get(i).getStlSeq()); 	
 						 						 						
 						log.debug("new_acct_yrmon= "+acctYrmon); 						
 						log.debug("new_stlVvdSeq = "+stlVvdSeq);
 						log.debug("new_stlSeq = "+stlSeq); 						
 						 						
 						dbDao.addTargetVVD(jooStlVvdVO);
 						list.get(i).setCmbCfmFlg("N");			//Combined No가 없더라도 해당 rlane에 권한이 없으면 선택 못한다.
 	 					dbDao.addSettlement(list.get(i), acctYrmon, stlVvdSeq, stlSeq);
 	 					
 	 					revYrmon = list.get(i).getRevYrmon();
 	 					revYrmonSeq = list.get(i).getRevYrmonSeq();
 	 					revSeq = list.get(i).getRevSeq();
 	 						 					 	 					
 						log.debug("revYrmon = "+revYrmon);
 						log.debug("revYrmonSeq = "+revYrmonSeq);
 						log.debug("revSeq = "+revSeq); 						
 	 					
	 					dbDao.modifySettlemntTaget(acctYrmon, stlVvdSeq, stlSeq, signOnUserAccount.getUsr_id(), revYrmon, revYrmonSeq, revSeq);
 					}
 			}
 			
 			if (iDupCnt > 0){
 				list.get(0).setDupFlg("E");
 			}else{
 				list.get(0).setDupFlg("N");
 			}
 		} catch (DAOException ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Save"}).getMessage(), ex);
 		} catch (Exception ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Save"}).getMessage(), ex);
 		}
 		
 		return list;
 	}
 	
	/**
	 * Trade코드List를 조회한다.
	 * @param JoSettlementConditionVO joSettlementConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchTradeCodeListStl(JoSettlementConditionVO joSettlementConditionVO) throws EventException {
		try {
			return dbDao.searchTradeCodeListStl(joSettlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * Rlane코드List를 조회한다.
	 * @param JoSettlementConditionVO joSettlementConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchRlaneCodeListStl(JoSettlementConditionVO joSettlementConditionVO) throws EventException {
		try {
			return dbDao.searchRlaneCodeListStl(joSettlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Rlane Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Rlane Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	 /**
	 * Carrier코드List를 조회한다.
	 * 
	 * @param JoSettlementConditionVO joSettlementConditionVO
	 * @return List<EstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchCarrierCodeListStl(JoSettlementConditionVO joSettlementConditionVO) throws EventException {
		try {
			return dbDao.searchCarrierCodeListStl(joSettlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
    /**
     * JO Settlement Status Information - JOO_SLT_PRC 프로시져 테스트용
     * 
     * @param String p_vsl_cd
     * @param String p_skd_voy_no
     * @param String p_skd_dir_cd 
     * @throws EventException
     */
    public void callProcedure(String p_vsl_cd, String p_skd_voy_no, String p_skd_dir_cd) throws EventException {
        try {
            dbDao.callProcedure(p_vsl_cd, p_skd_voy_no, p_skd_dir_cd);
			  } catch (DAOException ex) {
			   log.error("err " + ex.toString(), ex);
			   throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
			  } catch (Exception ex) {
			   log.error("err " + ex.toString(), ex);
			   throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
    
    /**
     * JO Expense Loading Information - JOO_ROB_CNTR_SMRY_PAS_PRC 프로시져 테스트용
     * 
     * @param TdrLoadVO tdrLoadVO
     * @returnType 
     * @throws EventException
     */
    public String callJELProcedure(TdrLoadVO tdrLoadVO) throws EventException {
    	String pErrorCode = "";
        try {
        	pErrorCode = dbDao.callJELProcedure(tdrLoadVO);
		  } catch (DAOException ex) {
		   log.error("err " + ex.toString(), ex);
		   throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		  } catch (Exception ex) {
		   log.error("err " + ex.toString(), ex);
		   throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
        return pErrorCode;
    }

    /**
     * FNS_JOO_0111: Retrieve
     * Jo Expense Report 리스트를 Retrieve 합니다.<br>
     *  
     * @param TdrLoadVO tdrLoadVO
     * @param SignOnUserAccount signOnUserAccount
     * @param String gubun
     * @return  List<JoLoadingVO>
     * @throws EventException 
     */
    public  List<JoLoadingVO> searchExpRptList(TdrLoadVO tdrLoadVO, SignOnUserAccount signOnUserAccount, String gubun) throws EventException {    	
    	List<JoLoadingVO> list = null;    	
    	    	
    	try {
    		list =  dbDao.searchExpRptList(tdrLoadVO, gubun);
    		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"ROB SUMMARY List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"ROB SUMMARY List", "Retrieve"}).getUserMessage(), ex);
		}
    	
    	return list;
    }
    
    /**
     * Movement Event Date Setting - JOO_CNTR_MVMT_EVNT_DT_SLAN_PRC 프로시져 호출
     * 
     * @param MvntEvntDtVO mvntEvntDtVO
     * @returnType 
     * @throws EventException
     */
    public String callMVMTProcedure(MvntEvntDtVO mvntEvntDtVO) throws EventException {
    	String pErrorCode = "";
        try {
        	pErrorCode = dbDao.callMVMTProcedure(mvntEvntDtVO);
		  } catch (DAOException ex) {
		   log.error("err " + ex.toString(), ex);
		   throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		  } catch (Exception ex) {
		   log.error("err " + ex.toString(), ex);
		   throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
        return pErrorCode;
    }
    
    /**
     * Movement Event Date Setting - JOO_CNTR_MVMT_EVNT_DT_ALL_PRC 프로시져 호출
     * 
     * @param MvntEvntDtVO mvntEvntDtVO
     * @returnType 
     * @throws EventException
     */
    public String callMVMTALLProcedure(MvntEvntDtVO mvntEvntDtVO) throws EventException {
    	String pErrorCode = "";
        try {
        	pErrorCode = dbDao.callMVMTALLProcedure(mvntEvntDtVO);
		  } catch (DAOException ex) {
		   log.error("err " + ex.toString(), ex);
		   throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		  } catch (Exception ex) {
		   log.error("err " + ex.toString(), ex);
		   throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
        return pErrorCode;
    }
    
    /**
     * callSLOTProcedure - JOO_SLT_ALL_PRC 프로시져 호출
     * 
     * @param JoEstmConditionVO estmConditionVO
     * @returnType String
     * @throws EventException
     */
    public String callSLOTProcedure(JoEstmConditionVO estmConditionVO) throws EventException {
    	String pErrorCode = "";
        try {
        	pErrorCode = dbDao.callSLOTProcedure(estmConditionVO);
		  } catch (DAOException ex) {
		   log.error("err " + ex.toString(), ex);
		   throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		  } catch (Exception ex) {
		   log.error("err " + ex.toString(), ex);
		   throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
        return pErrorCode;
    }
    
    
	/**
	 * Settlement 단에서 Row ADD로 VVD입력시 9자리만 입력하면 해당하는 Revenue Direction List를 대상항차에서 조회한다.
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchRevDirList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchRevDirList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Revenue Direction List", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Revenue Direction List", "Retrieve"}).getMessage(), ex);
		}
	}    
	
    /**
     * JO Settlement PIC정보를 조회한다. 
     * 
     * @param StlStsVO stlStsVO
     * @returnType List<StlStsVO>
     * @throws EventException
     */
    public List<StlStsVO> searchJoSettlementPicList(StlStsVO stlStsVO) throws EventException {
        try {
            return dbDao.searchJoSettlementPicList(stlStsVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }			
    
    /**
     * JO Settlement PIC페이지 개수 정보를 조회한다. 
     * 
     * @param StlStsVO stlStsVO
     * @returnType StlStsVO
     * @throws EventException
     */
    public StlStsVO searchJoSettlementPicListTotal(StlStsVO stlStsVO) throws EventException {
        try {
            return dbDao.searchJoSettlementPicListTotal(stlStsVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }		
    
    /**
     * 공동운항에서 PIC 조회
     * 
     * @returnType List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchPicList() throws EventException {
        try {
            return dbDao.searchPicList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }			
    
    /**
     * Pic 정보를 저장 합니다.<br>
     *  
     * @param  StlStsVO[] stlStsVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @return  String
     * @throws EventException
     */
	public String managePic(StlStsVO[] stlStsVOs, SignOnUserAccount signOnUserAccount) throws EventException {

		StringBuilder rtnVal = new StringBuilder();
		rtnVal.append("");
        try{
    			List<StlStsVO> insertVoList = new ArrayList<StlStsVO>();
    			List<StlStsVO> updateVoList = new ArrayList<StlStsVO>();
    			List<StlStsVO> deleteVoList = new ArrayList<StlStsVO>();
    			
    			String ibflag = "";
				String tmpVal = null;

    			for (int inx=0; inx < stlStsVOs.length; inx++){
    				ibflag = stlStsVOs[inx].getIbflag();
    				
    				stlStsVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
    				    				    				    				
    				if ("I".equals(ibflag)){
    					//Duplicate Check
    					tmpVal = "";
    					tmpVal = dbDao.searchPicDupCheck(stlStsVOs[inx]);    					
    					
    					if ("".equals(tmpVal)){  		
        					insertVoList.add(stlStsVOs[inx]);
    					} else {
    						rtnVal.append(tmpVal + "\n");
    					}
    				}else if("U".equals(ibflag)){    					    					
    					//Duplicate Check
//	    					tmpVal = "";
//	    					tmpVal = dbDao.searchPicDupCheck(stlStsVOs[inx]);
//	    					
//	    					if ("".equals(tmpVal)){  	
//	    						updateVoList.add(stlStsVOs[inx]);
//	    					} else {
//	    						rtnVal.append(tmpVal + "\n");
//	    					}
    					updateVoList.add(stlStsVOs[inx]);    					
    				}
	    			else if("D".equals(ibflag)){
    					deleteVoList.add(stlStsVOs[inx]);	    				
	    			}
    			}
    			if ("".equals(rtnVal.toString()) && insertVoList.size() > 0 ) {
					dbDao.addPic(insertVoList);
    			}    			
    			if ("".equals(rtnVal.toString()) && updateVoList.size() > 0 ) {
    				dbDao.modifyPic(updateVoList);
    			}
    			if ("".equals(rtnVal.toString()) && deleteVoList.size() > 0 ) {
    				dbDao.removePic(deleteVoList);
    			}
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Mapping", "Save"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Mapping", "Save"}).getMessage(), ex);
        }
        
		return rtnVal.toString();
  
    }    
    
    /** 
     * Pic를 저장 합니다.(Multi Creation & Change)
     *
     * @param StlStsVO[] stlStsVOs
     * @param SignOnUserAccount account 
     * @throws EventException
     */
    public void manageMultiPic(StlStsVO[] stlStsVOs, SignOnUserAccount account) throws EventException{
		try {
			List<StlStsVO> insertVoList = new ArrayList<StlStsVO>();
			List<StlStsVO> updateVoList = new ArrayList<StlStsVO>();			
			String tmpVal = null;			
			
			for (int inx=0; inx < stlStsVOs.length; inx++){				
				stlStsVOs[inx].setUpdUsrId(account.getUsr_id());
				
				tmpVal = "";
				tmpVal = dbDao.searchPicDupCheck(stlStsVOs[inx]);    						
		
				if ("".equals(tmpVal)){  		
					insertVoList.add(stlStsVOs[inx]);    				
				} else {
					updateVoList.add(stlStsVOs[inx]);					
				}					
			}
			
			if (insertVoList.size() > 0 ) {
				dbDao.addPic(insertVoList);
			}    			
			if (updateVoList.size() > 0 ) {
				dbDao.modifyPic(updateVoList);
			}			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}    	
    }         		
}