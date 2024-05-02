/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EDISetupDBDAO.java
*@FileTitle : EDISetupDBDAO 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-16
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009-09-06 전병석
* 1.0 최초 생성
* 2009-10-16 
* 1.2 버전생성
* 2011.03.18 김진승 [CHM-201108940-01][CSR] edi.hanjin.com customer type 별 전송 로직 추가 요청 처리 
* 2011.11.11 이경원 [CHM-201114265-01] ALPS EDI History 기능 개발
* 2012.07.12 채창호 [CHM-201218302-01][SCEM] Visibility Upgrade Project 개발 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edisetup.integration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.irep.enisEsd.ESD0280001Document.ESD0280001.DataArea.CmMarkDescCollection.CmMarkDesc;
import com.hanjin.irep.enisEsd.ESD0310001Document.ESD0310001.DataArea.EDICargoStnStsCollection.EDICargoStnSts;
import com.hanjin.irep.enisEsd.ESD0320001Document.ESD0320001.DataArea.EDIGroupCollection.EDIGroup;
import com.hanjin.irep.enisEsd.ESD0330001Document.ESD0330001.DataArea.EDIGrpCgoCollection.EDIGrpCgo;
import com.hanjin.irep.enisEsd.ESD0340001Document.ESD0340001.DataArea.EDIGrpCustCollection.EDIGrpCust;
import com.hanjin.irep.enisEsd.ESD0100001Document.ESD0100001.DataArea.TRODATACollection.TRODATARequest;

/**
 * ENIS-SCE에 대한 DB 처리를 담당<br>
 * - ENIS-SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yong-cheon Shin
 * @see ReceiveEAIBCImpl 참조
 * @since J2EE 1.4
 */
public class EDISetupDBDAO   extends DBDAOSupport {
	
	/** EDI_CGO_STND_STS TABLE을 update(insert) 또는 delete(eai status에 따라)한다.
	 * @param EDICargoStnSts[] cargo_stns_array
	 * @throws DAOException
	 */
	public void syncEdi_cgo_stnd_sts(EDICargoStnSts[] cargo_stns_array)  throws DAOException{
	    DBRowSet dbRowset = null;
	    int isexist_count = 0;
	    int insCnt = 0;
	 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//{call SCE_SYNC_EDI_CGO_STND_STS_PRC(?,?,?,?,?,?,?,?,?,?)}
		for(int i = 0 ; i < cargo_stns_array.length ; i ++){
			log.debug("P1["+i+"] "+cargo_stns_array[i].getSTATUSSTDCD());
			log.debug("P2["+i+"] "+cargo_stns_array[i].getCOMPANYCD());
			log.debug("P3["+i+"] "+cargo_stns_array[i].getSTATUSSEQ());
			log.debug("P4["+i+"] "+cargo_stns_array[i].getSTATUSDESC());
			log.debug("P5["+i+"] "+"");
			log.debug("P6["+i+"] "+"");
			log.debug("P7["+i+"] "+cargo_stns_array[i].getEAIDATE());
			log.debug("P8["+i+"] "+cargo_stns_array[i].getEAISTS());
			
			String statusStdCd_1 = cargo_stns_array[i].getSTATUSSTDCD();
			String companyCd_2   = cargo_stns_array[i].getCOMPANYCD();
			String statusSeq_3   = cargo_stns_array[i].getSTATUSSEQ();
			String statusDesc_4  = cargo_stns_array[i].getSTATUSDESC();
			String args_5        = "";
			String args_6        = "";
			String eaiDate_7     = cargo_stns_array[i].getEAIDATE();
			String eaiSts_8      = cargo_stns_array[i].getEAISTS();


		     /*파라미터 입력*/ 	
			  Map<String, String> mapVO = new HashMap();
				        mapVO.put("status_std_cd",statusStdCd_1); 
				        mapVO.put("company_cd",companyCd_2);       
						mapVO.put("status_seq",statusSeq_3);       
						mapVO.put("status_desc",statusDesc_4);        
						mapVO.put("origin_cd",args_5);            
						mapVO.put("dest_cd",args_6);     
						mapVO.put("eai_date",eaiDate_7);    
						mapVO.put("eai_sts",eaiSts_8);       
						
		     param.putAll(mapVO);
		     velParam.putAll(mapVO);

		     //IF eai_sts = 'U' THEN
		     //ELSIF eai_sts = 'D'
		/*로직구현*/  
		
	    try{	     
		     if(eaiSts_8 != null && eaiSts_8.equals("U")){//EAI 에서 넘어오는 인자값
		    	 log.debug("EDISetupDBDAOSearchEdiCgoStndStsCntRSQL Counting Information"); 
			    		dbRowset = new SQLExecuter("").executeQuery(
								 (ISQLTemplate) new EDISetupDBDAOSearchEdiCgoStndStsCntRSQL(),
								  param, velParam);
			    		 
			 		    if(dbRowset.getRowCount()>0){//if-1
					    	dbRowset.next();
					    	isexist_count =  dbRowset.getInt(1);
					    }//if-1
				    	 //IF isexist_count = 0 THEN
				    	 //insert 
				    	 //ELSE
				    	 //update
			 		   if(isexist_count == 0){//if-2
			 			   //Insert
			 			  log.debug("EDISetupDBDAOAddEdiCgoStndStsCSQL Insert Information");		 	
			 			  log.debug("status_std_cd :" + statusStdCd_1); 
			 			  log.debug("company_cd :" + companyCd_2);       
			 			  log.debug("status_seq :" + statusSeq_3);       
			 			  log.debug("status_desc :" + statusDesc_4);        
			 			  log.debug("origin_cd :" + args_5);            
			 			  log.debug("dest_cd :" + args_6);     
			 			  log.debug("eai_date :" + eaiDate_7);    
			 			  log.debug("eai_sts :" + eaiSts_8);  
			 			  
			 			  if(mapVO.size() > 0){
			 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOAddEdiCgoStndStsCSQL(), param, velParam);
			 						if(insCnt == Statement.EXECUTE_FAILED)
			 							throw new DAOException("Fail to Insert No["+ i + "] at SQL: EDISetupDBDAOAddEdiCgoStndStsCSQL");
			 			  }//if			 			  
			 			   
			 		   }else{
			 			  //Update 
			 			      log.debug("EDISetupDBDAOModifyEdiCgoStndStsUSQL Update Information");
				 			  log.debug("status_std_cd :" + statusStdCd_1); 
				 			  log.debug("company_cd :" + companyCd_2);       
				 			  log.debug("status_seq :" + statusSeq_3);       
				 			  log.debug("status_desc :" + statusDesc_4);        
				 			  log.debug("origin_cd :" + args_5);            
				 			  log.debug("dest_cd :" + args_6);     
				 			  log.debug("eai_date :" + eaiDate_7);    
				 			  log.debug("eai_sts :" + eaiSts_8);  
				 			  			 			   
			 		     if(mapVO.size() > 0){//if-3
			 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOModifyEdiCgoStndStsUSQL(), param, velParam);
			 						if(insCnt == Statement.EXECUTE_FAILED)
			 							throw new DAOException("Fail to Update No["+ i + "] at SQL: EDISetupDBDAOModifyEdiCgoStndStsUSQL");
			 			 }//if-3			 			   
			 			   
			 			   
			 		   }//if-2
			 		    
					
		     }else if(eaiSts_8 != null && eaiSts_8.equals("D")){
		    		//Delete 문
			      log.debug("EDISetupDBDAODeleteEdiCgoStndStsDSQL Delete Information");
	 			  log.debug("status_std_cd :" + statusStdCd_1);     
	 			  log.debug("eai_date :" + eaiDate_7);    
	 			  log.debug("eai_sts :" + eaiSts_8);           

					if(mapVO.size() > 0){//if-4
	 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAODeleteEdiCgoStndStsDSQL(), param, velParam);
	 						if(insCnt == Statement.EXECUTE_FAILED)
	 							throw new DAOException("Fail to Delete No["+ i + "] at SQL: EDISetupDBDAODeleteEdiCgoStndStsDSQL");
	 				}//if-4
		    	 
		     }//if
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}//try
			
	  }//for
	}
	
	
	/** EDI_GROUP_HIS TABLE을 insert 한다
	 * @param EDIGroup[] group_array
	 * @throws DAOException
	 * 2011.11.11 이경원 [CHM-201114265-01] ALPS EDI History 기능 개발
	 */
	public void syncEdi_group_his(EDIGroup[] group_array)  throws DAOException{
	 //   DBRowSet dbRowset = null;
	 //   int isexist_count = 0;
	    int insCnt = 0;
	 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	    //{call SCE_SYNC_EDI_GROUP_PRC(?,?,?,?,?,?,?,?,?,?,?)}
		for(int i = 0 ; i < group_array.length ; i ++){
        	log.debug("\n GROUPCD : " + group_array[i].getGROUPCD());
        	log.debug("\n COMPANY : " + group_array[i].getCOMPANYCD());
        	log.debug("\n GROUPNAME : " + group_array[i].getGROUPNM());
        	log.debug("\n GROUPTPID : " + group_array[i].getCUSTTPID());
        	log.debug("\n HOSTTPID : " + group_array[i].getHOSTTPID());
        	log.debug("\n DELIND : " + group_array[i].getDELIND());
        	log.debug("\n ID : " + "SYSTEM");
        	log.debug("\n EAIDATE : " + group_array[i].getEAIDATE());
        	log.debug("\n EAISTS : " + group_array[i].getEAISTS());
        
        	String groupCd_1   = group_array[i].getGROUPCD();
        	String company_2   = group_array[i].getCOMPANYCD();
        	String groupName_3 = group_array[i].getGROUPNM();
        	String groupTpId_4 = group_array[i].getCUSTTPID();
        	String hostTpId_5  = group_array[i].getHOSTTPID();
        	String delInd_6    = group_array[i].getDELIND();
        	String id_7        = "SYSTEM";
        	String eaiDate_8   = group_array[i].getEAIDATE();
        	String eaiSts_9   = group_array[i].getEAISTS();

		     /*파라미터 입력*/ 	
			 Map<String, String> mapVO = new HashMap();
				        mapVO.put("group_cd",groupCd_1); 
				        mapVO.put("company_cd",company_2);       
						mapVO.put("group_nm",groupName_3);       
						mapVO.put("cust_tp_id",groupTpId_4);        
						mapVO.put("host_tp_id",hostTpId_5);            
						mapVO.put("del_ind",delInd_6);     
						mapVO.put("cre_id",id_7);    
						mapVO.put("eai_date",eaiDate_8); 
						mapVO.put("eai_sts",eaiSts_9); 
						
		     param.putAll(mapVO);
		     velParam.putAll(mapVO);
		     	     
		     try {
		    	// 2011.11.11 이경원 edi_grp_his 테이블에 히스토리 저장
		    	 if(mapVO.size() > 0){
		    		 insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOHistoryEdiGroupCSQL(), param, velParam);
						if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No["+ i + "] at SQL: EDISetupDBDAOHistoryEdiGroupCSQL");
		    	 }
		     } catch (SQLException se) {
		 		log.error(se.getMessage(), se);
		 		throw new DAOException(new ErrorHandler(se).getMessage());
		 	} catch (Exception ex) {
		 		log.error(ex.getMessage(), ex);
		 		throw new DAOException(new ErrorHandler(ex).getMessage());
		 	}//try
		 	
		}
	
}

		
	/** EDI_GRP_CGO_HIS TABLE을 insert 한다
	 * @param EDIGrpCgo[] edi_group_array
	 * @throws DAOException
	 * 2011.11.11 이경원 [CHM-201114265-01] ALPS EDI History 기능 개발
	 */
	public void syncEdi_grp_cgo_his(EDIGrpCgo[] edi_group_array)  throws DAOException{
	    int insCnt = 0;
	 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		log.debug("===================================== edi_group_array.length :"+edi_group_array.length);
		
		for(int i = 0 ; i < edi_group_array.length ; i ++){
					
					log.debug("syncEdi_grp_cgo Parameters Information");
			        log.debug("e_edi_grp_cd[" + i + "]" + ":" + 			edi_group_array[i].getGROUPCD());
					log.debug("e_co_div_cd[" + i + "]" + ":" +              edi_group_array[i].getCOMPANYCD());
					log.debug("e_edi_stnd_sts_cd["+  i + "]" + ":" +        edi_group_array[i].getSTATUSSTDCD());
					log.debug("e_edi_evnt_cd["+ i + "]" + ":" +            	edi_group_array[i].getEVENTSEQ());
					log.debug("e_cust_edi_sts_cd["+ i + "]" + ":" +        	edi_group_array[i].getSTATUSCUSTCD());
					log.debug("e_edi_snd_flg["+ i + "]" + ":" +            	edi_group_array[i].getSENDIND());
					log.debug("e_edi_vsl_tp_cd["+ i + "]" + ":" +          	edi_group_array[i].getVSLTP());
					log.debug("e_edi_snd_itval_hr["+ i + "]" + ":" +       	edi_group_array[i].getSNDITVALHR());
					log.debug("e_edi_cntr_snd_tp_flg["+ i + "]" + ":" +    	edi_group_array[i].getCNTRTYPFLG());
					log.debug("eai_date["+ i + "]" + ":" +                 	edi_group_array[i].getEAIDATE());
					log.debug("eai_sts["+ i + "]" + ":" +                   edi_group_array[i].getEAISTS());
					log.debug("e_EDI_STS_SEQ["+ i + "]" + ":" +             edi_group_array[i].getSEQ());
					log.debug("e_ORG_CONTI_DESC["+ i + "]" + ":" +          edi_group_array[i].getORGCONTI());
					log.debug("e_ORG_DEST_CNT_DESC["+ i + "]" + ":" +      	edi_group_array[i].getORGCOUNTRYS());
					log.debug("e_DEST_CONTI_DESC["+ i + "]" + ":" +        	edi_group_array[i].getDESTCONTI());
					log.debug("e_DEST_CNT_DESC["+ i + "]" + ":" +          	edi_group_array[i].getDESTCOUNTRYS());
					log.debug("e_EDI_CGO_RMK["+ i + "]" + ":" +            	edi_group_array[i].getREMARK());
					log.debug("e_EDI_AUTO_SND_FLG["+ i  + "]" + ":" +	    getNullValue(edi_group_array[i].getSENDAUTOIND(), "N"));
					log.debug("e_STS_SND_TP_CD["+ i  + "]" + ":" +	    	getNullValue(edi_group_array[i].getSTSSNDAUTOTP(), "1"));
					
			
					
					String	groupCd_1    	    =	edi_group_array[i].getGROUPCD();
					String	companyCd_2      	=	edi_group_array[i].getCOMPANYCD();
					String	statusStdCd_3    	=	edi_group_array[i].getSTATUSSTDCD();
					String	eventSeq_4    	    =	edi_group_array[i].getEVENTSEQ();
					String	statusCustCd_5      =	edi_group_array[i].getSTATUSCUSTCD();
					String	sendInd_6    	    =	edi_group_array[i].getSENDIND();
					String	vslTp_7    	        =	edi_group_array[i].getVSLTP();
					String	sndItvalHr_8    	=	edi_group_array[i].getSNDITVALHR();
					String	cntrTypFlg_9    	=	edi_group_array[i].getCNTRTYPFLG();
					String	eaiDate_10    	    =	edi_group_array[i].getEAIDATE();
					String	eaiSts_11    	    =	edi_group_array[i].getEAISTS();
					String	seq_12    	        =	edi_group_array[i].getSEQ();
					String	orgConti_13    	    =	edi_group_array[i].getORGCONTI();
					String	orgCountrys_14    	=	edi_group_array[i].getORGCOUNTRYS();
					String	destConti_15    	=	edi_group_array[i].getDESTCONTI();
					String	destCountrys_16     =	edi_group_array[i].getDESTCOUNTRYS();
					String	remark_17   	    =	edi_group_array[i].getREMARK(); 
					String  sendAutoInd_18      =   getNullValue(edi_group_array[i].getSENDAUTOIND(), "N");
					String  stsSndTyCd_19      =   getNullValue(edi_group_array[i].getSTSSNDAUTOTP(), "1");

				     /*파라미터 입력*/ 	
					  Map<String, String> mapVO = new HashMap();
					  mapVO.put("e_edi_grp_cd",groupCd_1);	
					  mapVO.put("e_co_div_cd",companyCd_2);	
					  mapVO.put("e_edi_stnd_sts_cd",statusStdCd_3);	
					  mapVO.put("e_edi_evnt_cd",eventSeq_4);	
					  mapVO.put("e_cust_edi_sts_cd",statusCustCd_5);	
					  mapVO.put("e_edi_snd_flg",sendInd_6);	
					  mapVO.put("e_edi_vsl_tp_cd",vslTp_7);
					  mapVO.put("e_edi_snd_itval_hr",sndItvalHr_8);
					  mapVO.put("e_edi_cntr_snd_tp_flg",cntrTypFlg_9);
					  mapVO.put("eai_date",eaiDate_10);
					  mapVO.put("eai_sts",eaiSts_11);
					  mapVO.put("e_EDI_STS_SEQ",seq_12);
					  mapVO.put("e_ORG_CONTI_DESC",orgConti_13);
					  mapVO.put("e_ORG_DEST_CNT_DESC",orgCountrys_14);
					  mapVO.put("e_DEST_CONTI_DESC",destConti_15);
					  mapVO.put("e_DEST_CNT_DESC",destCountrys_16);
					  mapVO.put("e_EDI_CGO_RMK",remark_17);
					  mapVO.put("e_EDI_AUTO_SND_FLG",sendAutoInd_18);
					  mapVO.put("e_STS_SND_TP_CD",stsSndTyCd_19);
								
				     param.putAll(mapVO);
				     velParam.putAll(mapVO);
		     
				     // 로직구현
				     
				     try{
				    	 if(mapVO.size() > 0){
				    		 insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOHistoryEdiGrpCgoCSQL(), param, velParam);
								if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to Insert No["+ i + "] at SQL: EDISetupDBDAOHistoryEdiGrpCgoCSQL");
				    	 }
					} catch (SQLException se) {
						log.error(se.getMessage(), se);
						throw new DAOException(new ErrorHandler(se).getMessage());
					} catch (Exception ex) {
						log.error(ex.getMessage(), ex);
						throw new DAOException(new ErrorHandler(ex).getMessage());
					}//try
					
		}
	}
	
	/** EDI_GRP_CUST_HIS TABLE을 insert 한다
	 * @param EDIGrpCust[] group_cust_array
	 * @throws DAOException
	 * 2011.11.11 이경원 [CHM-201114265-01] ALPS EDI History 기능 개발
	 */
	public void syncEdi_grp_cust_his(EDIGrpCust[] group_cust_array)  throws DAOException{

	    int insCnt = 0;
	 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		for(int i = 0 ; i < group_cust_array.length ; i ++){
	    	log.debug("P1["+i+"] "+group_cust_array[i].getGROUPCD());
	    	log.debug("P2["+i+"] "+group_cust_array[i].getCOMPANYCD());
	    	log.debug("P3["+i+"] "+group_cust_array[i].getCNTCD());
	    	log.debug("P4["+i+"] "+group_cust_array[i].getCUSTCD());
	    	log.debug("P5["+i+"] "+group_cust_array[i].getSCNO());
	    	log.debug("P6["+i+"] "+group_cust_array[i].getSCEFFFRDT());
	    	log.debug("P7["+i+"] "+group_cust_array[i].getSCEFFTODT());
	    	log.debug("P8["+i+"] "+group_cust_array[i].getDELYN());
	    	log.debug("P9["+i+"] "+group_cust_array[i].getCGOTRKYN());
	    	log.debug("P10["+i+"] "+group_cust_array[i].getBKGCTRTDIVCD());
	    	log.debug("P11["+i+"] "+group_cust_array[i].getEAIDATE());
	    	log.debug("P12["+i+"] "+group_cust_array[i].getEAISTS());
	    	log.debug("P13["+i+"] "+group_cust_array[i].getCUSTTYPES()); // 2011.03.18 김진승
	    	log.debug("P14["+i+"] "+group_cust_array[i].getCGOTRKBATYN());
	    		
	    	/*로직구현*/
	    	String  groupCd_1       = group_cust_array[i].getGROUPCD();
	    	String  companyCd_2     = group_cust_array[i].getCOMPANYCD();
	    	String  cntCd_3         = getNullValue(group_cust_array[i].getCNTCD()," ");
	    	String  custCd_4        = getNullValue(group_cust_array[i].getCUSTCD(),"0");
	    	String  scNo_5          = getNullValue(group_cust_array[i].getSCNO()," ");
	    	String  scEffFrDt_6     = group_cust_array[i].getSCEFFFRDT();
	    	String  scEffToDt_7     = group_cust_array[i].getSCEFFTODT();
	    	String  delYn_8         = group_cust_array[i].getDELYN();
	    	String  cgoTrkYn_9      = group_cust_array[i].getCGOTRKYN();
	    	String  bkgCtrtDivCd_10 = group_cust_array[i].getBKGCTRTDIVCD();//jar 파일에 반영되지 않았음..
	    	String  eaiDate_11      = group_cust_array[i].getEAIDATE();
	    	String  eaiSts_12       = group_cust_array[i].getEAISTS();
	    	String  custTypes_13       = group_cust_array[i].getCUSTTYPES(); // 2011.03.18 김진승 
	    	String  cgoTrkBatYn        = group_cust_array[i].getCGOTRKBATYN();


	     /*파라미터 입력*/ 	
		  Map<String, String> mapVO = new HashMap();
			        mapVO.put("e_edi_grp_cd",groupCd_1); 
			        mapVO.put("e_co_div_cd",companyCd_2);       
					mapVO.put("e_cust_cnt_cd",cntCd_3);       
					mapVO.put("e_cust_seq",custCd_4);        
					mapVO.put("e_sc_no",scNo_5);            
					mapVO.put("e_sc_eff_st_dt",scEffFrDt_6);     
					mapVO.put("e_sc_eff_end_dt",scEffToDt_7);    
					mapVO.put("e_ib_svc_flg",delYn_8);       
					mapVO.put("e_cgo_trc_svc_flg",cgoTrkYn_9); 
					mapVO.put("e_bkg_ctrt_div_cd",bkgCtrtDivCd_10);	
					mapVO.put("eai_date",eaiDate_11);           
					mapVO.put("eai_sts",eaiSts_12);  
					mapVO.put("cust_types",custTypes_13);   // 2011.03.18 김진승 
					mapVO.put("cgo_trc_bat_flg" , cgoTrkBatYn);
					
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		     
			try{
				if(mapVO.size() > 0) {
		    	insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOHistoryEdiGrpCustCSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No["+ i + "] at SQL: EDISetupDBDAOHistoryEdiGrpCustCSQL");
				}
 		    } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
	}
	
	/** EDI_GROUP TABLE을 update(insert) 또는 delete(eai status에 따라)한다.
	 * @param EDIGroup[] group_array
	 * @throws DAOException
	 */
	public void syncEdi_group(EDIGroup[] group_array)  throws DAOException{
	    DBRowSet dbRowset = null;
	    int isexist_count = 0;
	    int insCnt = 0;
	 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	    //{call SCE_SYNC_EDI_GROUP_PRC(?,?,?,?,?,?,?,?,?,?,?)}
		for(int i = 0 ; i < group_array.length ; i ++){
        	log.debug("\n GROUPCD : " + group_array[i].getGROUPCD());
        	log.debug("\n COMPANY : " + group_array[i].getCOMPANYCD());
        	log.debug("\n GROUPNAME : " + group_array[i].getGROUPNM());
        	log.debug("\n GROUPTPID : " + group_array[i].getCUSTTPID());
        	log.debug("\n HOSTTPID : " + group_array[i].getHOSTTPID());
        	log.debug("\n DELIND : " + group_array[i].getDELIND());
        	log.debug("\n ID : " + "SYSTEM");
        	log.debug("\n EAIDATE : " + group_array[i].getEAIDATE());
        	log.debug("\n EAISTS : " + group_array[i].getEAISTS());
        	/*
        	 *  cs.setString(1,group_array[i].getGROUPCD());
            	cs.setString(2,group_array[i].getCOMPANYCD());
                cs.setString(3,group_array[i].getGROUPNM());
                cs.setString(4,group_array[i].getCUSTTPID());
                cs.setString(5,group_array[i].getHOSTTPID());
                cs.setString(6,group_array[i].getDELIND());
                cs.setString(7,"SYSTEM");                
                cs.setString(8,group_array[i].getEAIDATE());
                cs.setString(9,group_array[i].getEAISTS());
                cs.setString(10,"00");
                cs.setString(11,"");
        	 * */
        	String groupCd_1   = group_array[i].getGROUPCD();
        	String company_2   = group_array[i].getCOMPANYCD();
        	String groupName_3 = group_array[i].getGROUPNM();
        	String groupTpId_4 = group_array[i].getCUSTTPID();
        	String hostTpId_5  = group_array[i].getHOSTTPID();
        	String delInd_6    = group_array[i].getDELIND();
        	String id_7        = "SYSTEM";
        	String eaiDate_8   = group_array[i].getEAIDATE();
        	String eaiSts_9   = group_array[i].getEAISTS();

		     /*파라미터 입력*/ 	
			 Map<String, String> mapVO = new HashMap();
				        mapVO.put("group_cd",groupCd_1); 
				        mapVO.put("company_cd",company_2);       
						mapVO.put("group_nm",groupName_3);       
						mapVO.put("cust_tp_id",groupTpId_4);        
						mapVO.put("host_tp_id",hostTpId_5);            
						mapVO.put("del_ind",delInd_6);     
						mapVO.put("cre_id",id_7);    
						mapVO.put("eai_date",eaiDate_8); 
						mapVO.put("eai_sts",eaiSts_9); 
						
		     param.putAll(mapVO);
		     velParam.putAll(mapVO);
		     //IF eai_sts = 'U' THEN
		     //ELSIF eai_sts = 'D' THEN
		try{
		     if(eaiSts_9 != null && eaiSts_9.equals("U")){//if
		    		dbRowset = new SQLExecuter("").executeQuery(
							 (ISQLTemplate) new EDISetupDBDAOSearchEdiGroupCntRSQL(),
							  param, velParam);		    		 
		 		    if(dbRowset.getRowCount()>0){//if-1
				    	dbRowset.next();
				    	isexist_count =  dbRowset.getInt(1);
				    }//if-1		    	 

			 		   if(isexist_count == 0){//if-2
			 			   //Insert
			 			    log.debug("EDISetupDBDAOAddEdiGroupCSQL Insert Information");
							log.debug("group_cd:" + groupCd_1); 
			                log.debug("company_cd:" + company_2);       
					        log.debug("group_nm:" + groupName_3);       
					        log.debug("cust_tp_id:" + groupTpId_4);
					        log.debug("host_tp_id:" + hostTpId_5); 					        
							log.debug("del_ind:" + delInd_6);     
							log.debug("cre_id:" + id_7);    
							log.debug("eai_date:" + eaiDate_8); 
							log.debug("eai_sts:" + eaiSts_9); 		
			 			  if(mapVO.size() > 0){
			 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOAddEdiGroupCSQL(), param, velParam);
			 						if(insCnt == Statement.EXECUTE_FAILED)
			 							throw new DAOException("Fail to Insert No["+ i + "] at SQL: EDISetupDBDAOAddEdiGroupCSQL");
			 			  }//if			 			  
			 			   
			 		   }else{
			 			  //Update 
			 			    log.debug("EDISetupDBDAOModifyEdiGroupUSQL Update Information");
							log.debug("group_cd:" + groupCd_1); 
			                log.debug("company_cd:" + company_2);       
					        log.debug("group_nm:" + groupName_3);       
					        log.debug("cust_tp_id:" + groupTpId_4);
					        log.debug("host_tp_id:" + hostTpId_5); 					        
							log.debug("del_ind:" + delInd_6);     
							log.debug("cre_id:" + id_7);    
							log.debug("eai_date:" + eaiDate_8); 
							log.debug("eai_sts:" + eaiSts_9); 			 
				 			  			 			   
			 		     if(mapVO.size() > 0){//if-3
			 		    		insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOModifyEdiGroupUSQL(), param, velParam);
			 						if(insCnt == Statement.EXECUTE_FAILED)
			 							throw new DAOException("Fail to Update No["+ i + "] at SQL: EDISetupDBDAOModifyEdiGroupUSQL");
			 			 }//if-3			 			   
			 		   }//if-2

		     }else if(eaiSts_9 != null && eaiSts_9.equals("D")){
		    		//Delete 문
			      log.debug("EDISetupDBDAODeleteEdiGroupDSQL Delete Information");
					log.debug("group_cd:" + groupCd_1); 
	                log.debug("company_cd:" + company_2);       
			        log.debug("group_nm:" + groupName_3);       
			        log.debug("cust_tp_id:" + groupTpId_4);
			        log.debug("host_tp_id:" + hostTpId_5); 					        
					log.debug("del_ind:" + delInd_6);     
					log.debug("cre_id:" + id_7);    
					log.debug("eai_date:" + eaiDate_8); 
					log.debug("eai_sts:" + eaiSts_9); 
					
					
					if(mapVO.size() > 0){//if-4
	 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAODeleteEdiGroupDSQL(), param, velParam);
	 						if(insCnt == Statement.EXECUTE_FAILED)
	 							throw new DAOException("Fail to Delete No["+ i + "] at SQL: EDISetupDBDAODeleteEdiGroupDSQL");
	 				}//if-4		    	 
		    	 
		     }//if
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}//try	
	  }//for
	}
	
	/** EDI_GRP_CGO TABLE을 update(insert) 또는 delete(eai status에 따라)한다.
	 * @param EDIGrpCgo[] edi_group_array
	 * @throws DAOException
	 */
	public void syncEdi_grp_cgo(EDIGrpCgo[] edi_group_array) throws DAOException{	
	    DBRowSet dbRowset = null;
	    int isexist_count = 0;
	    int insCnt = 0;
	 // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		log.debug("====================================== edi_group_array.length : " + edi_group_array.length);
		for(int i = 0 ; i < edi_group_array.length ; i ++){
			        log.debug("syncEdi_grp_cgo Parameters Information");
			        log.debug("e_edi_grp_cd[" + i + "]" + ":" + 			edi_group_array[i].getGROUPCD());
					log.debug("e_co_div_cd[" + i + "]" + ":" +              edi_group_array[i].getCOMPANYCD());
					log.debug("e_edi_stnd_sts_cd["+  i + "]" + ":" +        edi_group_array[i].getSTATUSSTDCD());
					log.debug("e_edi_evnt_cd["+ i + "]" + ":" +            	edi_group_array[i].getEVENTSEQ());
					log.debug("e_cust_edi_sts_cd["+ i + "]" + ":" +        	edi_group_array[i].getSTATUSCUSTCD());
					log.debug("e_edi_snd_flg["+ i + "]" + ":" +            	edi_group_array[i].getSENDIND());
					log.debug("e_edi_vsl_tp_cd["+ i + "]" + ":" +          	edi_group_array[i].getVSLTP());
					log.debug("e_edi_snd_itval_hr["+ i + "]" + ":" +       	edi_group_array[i].getSNDITVALHR());
					log.debug("e_edi_cntr_snd_tp_flg["+ i + "]" + ":" +    	edi_group_array[i].getCNTRTYPFLG());
					log.debug("eai_date["+ i + "]" + ":" +                 	edi_group_array[i].getEAIDATE());
					log.debug("eai_sts["+ i + "]" + ":" +                   edi_group_array[i].getEAISTS());
					log.debug("e_EDI_STS_SEQ["+ i + "]" + ":" +             edi_group_array[i].getSEQ());
					log.debug("e_ORG_CONTI_DESC["+ i + "]" + ":" +          edi_group_array[i].getORGCONTI());
					log.debug("e_ORG_DEST_CNT_DESC["+ i + "]" + ":" +      	edi_group_array[i].getORGCOUNTRYS());
					log.debug("e_DEST_CONTI_DESC["+ i + "]" + ":" +        	edi_group_array[i].getDESTCONTI());
					log.debug("e_DEST_CNT_DESC["+ i + "]" + ":" +          	edi_group_array[i].getDESTCOUNTRYS());
					log.debug("e_EDI_CGO_RMK["+ i + "]" + ":" +            	edi_group_array[i].getREMARK());
					log.debug("e_EDI_AUTO_SND_FLG["+ i  + "]" + ":" +	    getNullValue(edi_group_array[i].getSENDAUTOIND(), "N"));
					log.debug("e_STS_SND_TP_CD["+ i  + "]" + ":" +	    	getNullValue(edi_group_array[i].getSTSSNDAUTOTP(), "1"));
			
					
					String	groupCd_1    	    =	edi_group_array[i].getGROUPCD();
					String	companyCd_2      	=	edi_group_array[i].getCOMPANYCD();
					String	statusStdCd_3    	=	edi_group_array[i].getSTATUSSTDCD();
					String	eventSeq_4    	    =	edi_group_array[i].getEVENTSEQ();
					String	statusCustCd_5      =	edi_group_array[i].getSTATUSCUSTCD();
					String	sendInd_6    	    =	edi_group_array[i].getSENDIND();
					String	vslTp_7    	        =	edi_group_array[i].getVSLTP();
					String	sndItvalHr_8    	=	edi_group_array[i].getSNDITVALHR();
					String	cntrTypFlg_9    	=	edi_group_array[i].getCNTRTYPFLG();
					String	eaiDate_10    	    =	edi_group_array[i].getEAIDATE();
					String	eaiSts_11    	    =	edi_group_array[i].getEAISTS();
					String	seq_12    	        =	edi_group_array[i].getSEQ();
					String	orgConti_13    	    =	edi_group_array[i].getORGCONTI();
					String	orgCountrys_14    	=	edi_group_array[i].getORGCOUNTRYS();
					String	destConti_15    	=	edi_group_array[i].getDESTCONTI();
					String	destCountrys_16     =	edi_group_array[i].getDESTCOUNTRYS();
					String	remark_17   	    =	edi_group_array[i].getREMARK(); 
					String  sendAutoInd_18      =   getNullValue(edi_group_array[i].getSENDAUTOIND(), "N");
					String  stsSndTyCd_19      =   getNullValue(edi_group_array[i].getSTSSNDAUTOTP(), "1");

				     /*파라미터 입력*/ 	
					  Map<String, String> mapVO = new HashMap();
					  mapVO.put("e_edi_grp_cd",groupCd_1);	
					  mapVO.put("e_co_div_cd",companyCd_2);	
					  mapVO.put("e_edi_stnd_sts_cd",statusStdCd_3);	
					  mapVO.put("e_edi_evnt_cd",eventSeq_4);	
					  mapVO.put("e_cust_edi_sts_cd",statusCustCd_5);	
					  mapVO.put("e_edi_snd_flg",sendInd_6);	
					  mapVO.put("e_edi_vsl_tp_cd",vslTp_7);
					  mapVO.put("e_edi_snd_itval_hr",sndItvalHr_8);
					  mapVO.put("e_edi_cntr_snd_tp_flg",cntrTypFlg_9);
					  mapVO.put("eai_date",eaiDate_10);
					  mapVO.put("eai_sts",eaiSts_11);
					  mapVO.put("e_EDI_STS_SEQ",seq_12);
					  mapVO.put("e_ORG_CONTI_DESC",orgConti_13);
					  mapVO.put("e_ORG_DEST_CNT_DESC",orgCountrys_14);
					  mapVO.put("e_DEST_CONTI_DESC",destConti_15);
					  mapVO.put("e_DEST_CNT_DESC",destCountrys_16);
					  mapVO.put("e_EDI_CGO_RMK",remark_17);
					  mapVO.put("e_EDI_AUTO_SND_FLG",sendAutoInd_18);
					  mapVO.put("e_STS_SND_TP_CD",stsSndTyCd_19);
								
				     param.putAll(mapVO);
				     velParam.putAll(mapVO);
				     
				/*로직구현 */     
				try{
					if(eaiSts_11 != null && eaiSts_11.equals("U")){//EAI 에서 넘어오는 인자값
						
						//IF isexist_count = 0 THEN
						//ELSE
			    		dbRowset = new SQLExecuter("").executeQuery(
								 (ISQLTemplate) new EDISetupDBDAOSearchEdiGrpCgoCntRSQL(),
								  param, velParam);
			    		 
			 		    if(dbRowset.getRowCount()>0){//if-1
					    	dbRowset.next();
					    	isexist_count =  dbRowset.getInt(1);
					    }//if-1
				 		
			 		    if(isexist_count == 0){//if-2
				 			   //Insert
				 			log.debug("EDISetupDBDAOAddEdiGrpCgoCSQL Insert Information");		 	
				 			log.debug("e_edi_grp_cd[" + i + "]:"  + groupCd_1);	
				 			log.debug("e_co_div_cd[" + i + "]:"  + companyCd_2);	
				 			log.debug("e_edi_stnd_sts_cd[" + i + "]:"  + statusStdCd_3);	
				 			log.debug("e_edi_evnt_cd[" + i + "]:"  + eventSeq_4);	
				 			log.debug("e_cust_edi_sts_cd[" + i + "]:"  + statusCustCd_5);	
				 			log.debug("e_edi_snd_flg[" + i + "]:"  + sendInd_6);	
				 			log.debug("e_edi_vsl_tp_cd[" + i + "]:"  + vslTp_7);
				 			log.debug("e_edi_snd_itval_hr[" + i + "]:"  + sndItvalHr_8);
				 			log.debug("e_edi_cntr_snd_tp_flg[" + i + "]:"  + cntrTypFlg_9);
				 			log.debug("eai_date[" + i + "]:"  + eaiDate_10);
				 			log.debug("eai_sts[" + i + "]:"  + eaiSts_11);
				 			log.debug("e_EDI_STS_SEQ[" + i + "]:"  + seq_12);
				 			log.debug("e_ORG_CONTI_DESC[" + i + "]:"  + orgConti_13);
				 			log.debug("e_ORG_DEST_CNT_DESC[" + i + "]:"  + orgCountrys_14);
				 			log.debug("e_DEST_CONTI_DESC[" + i + "]:"  + destConti_15);
				 			log.debug("e_DEST_CNT_DESC[" + i + "]:"  + destCountrys_16);
				 			log.debug("e_EDI_CGO_RMK[" + i + "]:"  + remark_17);
				 			log.debug("e_EDI_AUTO_SND_FLG[" + i + "]:"  + sendAutoInd_18);
				 			log.debug("e_STS_SND_TP_CD["+ i  + "]" + ":" + stsSndTyCd_19);
				 			  
				 			  if(mapVO.size() > 0){
				 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOAddEdiGrpCgoCSQL(), param, velParam);
				 						if(insCnt == Statement.EXECUTE_FAILED)
				 							throw new DAOException("Fail to Insert No["+ i + "] at SQL: EDISetupDBDAOAddEdiGrpCgoCSQL");
				 			  }//if							
			 		    
			 		    }else{
			 			  //Update 
			 			    log.debug("EDISetupDBDAOModifyEdiGrpCgoUSQL Update Information");
				 			log.debug("EDISetupDBDAOAddEdiGrpCgoCSQL Insert Information");		 	
				 			log.debug("e_edi_grp_cd[" + i + "]:"  + groupCd_1);	
				 			log.debug("e_co_div_cd[" + i + "]:"  + companyCd_2);	
				 			log.debug("e_edi_stnd_sts_cd[" + i + "]:"  + statusStdCd_3);	
				 			log.debug("e_edi_evnt_cd[" + i + "]:"  + eventSeq_4);	
				 			log.debug("e_cust_edi_sts_cd[" + i + "]:"  + statusCustCd_5);	
				 			log.debug("e_edi_snd_flg[" + i + "]:"  + sendInd_6);	
				 			log.debug("e_edi_vsl_tp_cd[" + i + "]:"  + vslTp_7);
				 			log.debug("e_edi_snd_itval_hr[" + i + "]:"  + sndItvalHr_8);
				 			log.debug("e_edi_cntr_snd_tp_flg[" + i + "]:"  + cntrTypFlg_9);
				 			log.debug("eai_date[" + i + "]:"  + eaiDate_10);
				 			log.debug("eai_sts[" + i + "]:"  + eaiSts_11);
				 			log.debug("e_EDI_STS_SEQ[" + i + "]:"  + seq_12);
				 			log.debug("e_ORG_CONTI_DESC[" + i + "]:"  + orgConti_13);
				 			log.debug("e_ORG_DEST_CNT_DESC[" + i + "]:"  + orgCountrys_14);
				 			log.debug("e_DEST_CONTI_DESC[" + i + "]:"  + destConti_15);
				 			log.debug("e_DEST_CNT_DESC[" + i + "]:"  + destCountrys_16);
				 			log.debug("e_EDI_CGO_RMK[" + i + "]:"  + remark_17);
				 			log.debug("e_EDI_AUTO_SND_FLG[" + i + "]:"  + sendAutoInd_18);
				 			log.debug("e_STS_SND_TP_CD["+ i  + "]" + ":" + stsSndTyCd_19);
				 			  			 			   
			 		     if(mapVO.size() > 0){//if-3
			 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOModifyEdiGrpCgoUSQL(), param, velParam);
			 						if(insCnt == Statement.EXECUTE_FAILED)
			 							throw new DAOException("Fail to Update No["+ i + "] at SQL: EDISetupDBDAOModifyEdiGrpCgoUSQL");
			 			 }//if-3			 			   
			 		   }//if-2

					}else if(eaiSts_11 != null && eaiSts_11.equals("D")){
						//Delete
			 			log.debug("EDISetupDBDAODeleteEdiGrpCgoDSQL Delete Information");		 	
			 			log.debug("e_edi_grp_cd[" + i + "]:"  + groupCd_1);	
			 			log.debug("e_co_div_cd[" + i + "]:"  + companyCd_2);	
			 			log.debug("e_edi_stnd_sts_cd[" + i + "]:"  + statusStdCd_3);	
			 			log.debug("e_edi_evnt_cd[" + i + "]:"  + eventSeq_4);	
			 			log.debug("e_cust_edi_sts_cd[" + i + "]:"  + statusCustCd_5);	
			 			log.debug("e_edi_snd_flg[" + i + "]:"  + sendInd_6);	
			 			log.debug("e_edi_vsl_tp_cd[" + i + "]:"  + vslTp_7);
			 			log.debug("e_edi_snd_itval_hr[" + i + "]:"  + sndItvalHr_8);
			 			log.debug("e_edi_cntr_snd_tp_flg[" + i + "]:"  + cntrTypFlg_9);
			 			log.debug("eai_date[" + i + "]:"  + eaiDate_10);
			 			log.debug("eai_sts[" + i + "]:"  + eaiSts_11);
			 			log.debug("e_EDI_STS_SEQ[" + i + "]:"  + seq_12);
			 			log.debug("e_ORG_CONTI_DESC[" + i + "]:"  + orgConti_13);
			 			log.debug("e_ORG_DEST_CNT_DESC[" + i + "]:"  + orgCountrys_14);
			 			log.debug("e_DEST_CONTI_DESC[" + i + "]:"  + destConti_15);
			 			log.debug("e_DEST_CNT_DESC[" + i + "]:"  + destCountrys_16);
			 			log.debug("e_EDI_CGO_RMK[" + i + "]:"  + remark_17);
			 			log.debug("e_EDI_AUTO_SND_FLG[" + i + "]:"  + sendAutoInd_18);
			 			log.debug("e_STS_SND_TP_CD["+ i  + "]" + ":" + stsSndTyCd_19);

							if(mapVO.size() > 0){//if-4
			 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAODeleteEdiGrpCgoDSQL(), param, velParam);
			 						if(insCnt == Statement.EXECUTE_FAILED)
			 							throw new DAOException("Fail to Delete No["+ i + "] at SQL: EDISetupDBDAODeleteEdiGrpCgoDSQL");
			 				}//if-4						

					}//if

				} catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}//try
		
		}//for

	}
	/**EDI_GRP_CUST TABLE을 update(insert) 또는 delete(eai status에 따라)한다.
	 * @param EDIGrpCust[] group_cust_array
	 * @throws DAOException
	 */
	public void syncEdi_grp_cust(EDIGrpCust[] group_cust_array)  throws DAOException{
		//{call SCE_SYNC_EDI_GRP_CUST_PRC(?,?,?,?,?,?,?,?,?,?,?,?,?)}
    DBRowSet dbRowset = null;
    int isexist_count = 0;
    int insCnt = 0;
 // query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	// velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	for(int i = 0 ; i < group_cust_array.length ; i ++){
    	log.debug("P1["+i+"] "+group_cust_array[i].getGROUPCD());
    	log.debug("P2["+i+"] "+group_cust_array[i].getCOMPANYCD());
    	log.debug("P3["+i+"] "+group_cust_array[i].getCNTCD());
    	log.debug("P4["+i+"] "+group_cust_array[i].getCUSTCD());
    	log.debug("P5["+i+"] "+group_cust_array[i].getSCNO());
    	log.debug("P6["+i+"] "+group_cust_array[i].getSCEFFFRDT());
    	log.debug("P7["+i+"] "+group_cust_array[i].getSCEFFTODT());
    	log.debug("P8["+i+"] "+group_cust_array[i].getDELYN());
    	log.debug("P9["+i+"] "+group_cust_array[i].getCGOTRKYN());
    	log.debug("P10["+i+"] "+group_cust_array[i].getBKGCTRTDIVCD());
    	log.debug("P11["+i+"] "+group_cust_array[i].getEAIDATE());
    	log.debug("P12["+i+"] "+group_cust_array[i].getEAISTS());
    	log.debug("P13["+i+"] "+group_cust_array[i].getCUSTTYPES()); // 2011.03.18 김진승 
    	log.debug("P14["+i+"] "+group_cust_array[i].getCGOTRKYN());
    	
    	/*로직구현*/
    	String  groupCd_1       = group_cust_array[i].getGROUPCD();
    	String  companyCd_2     = group_cust_array[i].getCOMPANYCD();
    	String  cntCd_3         = getNullValue(group_cust_array[i].getCNTCD()," ");
    	String  custCd_4        = getNullValue(group_cust_array[i].getCUSTCD(),"0");
    	String  scNo_5          = getNullValue(group_cust_array[i].getSCNO()," ");
    	String  scEffFrDt_6     = group_cust_array[i].getSCEFFFRDT();
    	String  scEffToDt_7     = group_cust_array[i].getSCEFFTODT();
    	String  delYn_8         = group_cust_array[i].getDELYN();
    	String  cgoTrkYn_9      = group_cust_array[i].getCGOTRKYN();
    	String  bkgCtrtDivCd_10 = group_cust_array[i].getBKGCTRTDIVCD();//jar 파일에 반영되지 않았음..
    	String  eaiDate_11      = group_cust_array[i].getEAIDATE();
    	String  eaiSts_12       = group_cust_array[i].getEAISTS();
    	String  custTypes_13       = group_cust_array[i].getCUSTTYPES(); // 2011.03.18 김진승 
    	String  cgoTrkBatYn        = group_cust_array[i].getCGOTRKBATYN();

     /*파라미터 입력*/ 	
	  Map<String, String> mapVO = new HashMap();
		        mapVO.put("e_edi_grp_cd",groupCd_1); 
		        mapVO.put("e_co_div_cd",companyCd_2);       
				mapVO.put("e_cust_cnt_cd",cntCd_3);       
				mapVO.put("e_cust_seq",custCd_4);        
				mapVO.put("e_sc_no",scNo_5);            
				mapVO.put("e_sc_eff_st_dt",scEffFrDt_6);     
				mapVO.put("e_sc_eff_end_dt",scEffToDt_7);    
				mapVO.put("e_ib_svc_flg",delYn_8);       
				mapVO.put("e_cgo_trc_svc_flg",cgoTrkYn_9); 
				mapVO.put("e_bkg_ctrt_div_cd",bkgCtrtDivCd_10);	
				mapVO.put("eai_date",eaiDate_11);           
				mapVO.put("eai_sts",eaiSts_12);  
				mapVO.put("cust_types",custTypes_13);   // 2011.03.18 김진승 
				mapVO.put("cgo_trc_bat_flg" , cgoTrkBatYn);
				
		param.putAll(mapVO);
		velParam.putAll(mapVO);
    try{	
    	if(eaiSts_12 != null && eaiSts_12.equals("U")){//EAI 에서 넘어오는 인자값
		    		dbRowset = new SQLExecuter("").executeQuery(
							 (ISQLTemplate) new EDISetupDBDAOSearchEdiGrpCustCntRSQL(),
							  param, velParam);
		    		 
		 		    if(dbRowset.getRowCount()>0){//if-1
				    	dbRowset.next();
				    	isexist_count =  dbRowset.getInt(1);
				    }//if-1
		 		 
		 		    //IF isexist_count = 0 THEN
		 		    if(isexist_count == 0){//if-2
		 			   //insert 문
		 		    	log.debug("EDISetupDBDAOAddEdiGrpCustCSQL Update Information");
		 	            log.debug("e_edi_grp_cd :" + groupCd_1);
		 	            log.debug("e_co_div_cd :"  + companyCd_2);
		 	            log.debug("e_cust_cnt_cd :" + cntCd_3);
		 	            log.debug("e_cust_seq :" + custCd_4);
		 	            log.debug("e_sc_no :"  + scNo_5);
                        log.debug("e_sc_no :" + scNo_5);            
        				log.debug("e_sc_eff_st_dt :" + scEffFrDt_6);     
        				log.debug("e_sc_eff_end_dt :"+ scEffToDt_7);    
        				log.debug("e_ib_svc_flg :" + delYn_8);       
        				log.debug("e_cgo_trc_svc_flg:" + cgoTrkYn_9); 
        				log.debug("e_bkg_ctrt_div_cd:" + bkgCtrtDivCd_10);	
        				log.debug("eai_date:" + eaiDate_11);           
        				log.debug("eai_sts:" + eaiSts_12);  
        				log.debug("cust_types:" + custTypes_13);  // 2011.03.18 김진승 
        				log.debug("cgo_trc_bat_flg" + cgoTrkBatYn);
		 	            
		 				if(mapVO.size() > 0){
		 					
		 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOAddEdiGrpCustCSQL(), param, velParam);
		 						if(insCnt == Statement.EXECUTE_FAILED)
		 							throw new DAOException("Fail to Insert No["+ i + "] at SQL: EDISetupDBDAOAddEdiGrpCustCSQL");
		 				}//if
		 				
		 		    }else{//if-2
		 		    	//update 문
		 		    	log.debug("EDISetupDBDAOModifyEdiGrpCustUSQL Update Information");
		 	            log.debug("e_edi_grp_cd :" + groupCd_1);
		 	            log.debug("e_co_div_cd :"  + companyCd_2);
		 	            log.debug("e_cust_cnt_cd :" + cntCd_3);
		 	            log.debug("e_cust_seq :" + custCd_4);
		 	            log.debug("e_sc_no :"  + scNo_5);
		 	            log.debug("e_bkg_ctrt_div_cd :" + bkgCtrtDivCd_10);
        				log.debug("cust_types:" + custTypes_13);// 2011.03.18 김진승 
        				log.debug("cgo_trc_bat_flg" + cgoTrkBatYn);

		 				if(mapVO.size() > 0){//if-3
		 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAOModifyEdiGrpCustUSQL(), param, velParam);
		 						if(insCnt == Statement.EXECUTE_FAILED)
		 							throw new DAOException("Fail to Update No["+ i + "] at SQL: EDISetupDBDAOModifyEdiGrpCustUSQL");
		 				}//if-3

		 		    }//if-2
    	}else if(eaiSts_12 != null && eaiSts_12.equals("D")){
    		//Delete 문
			   //insert 문
		    	log.debug("EDISetupDBDAODeleteEdiGrpCustDSQL Delete Information");
	            log.debug("e_edi_grp_cd :" + groupCd_1);
	            log.debug("e_co_div_cd :"  + companyCd_2);
	            log.debug("e_cust_cnt_cd :" + cntCd_3);
	            log.debug("e_cust_seq :" + custCd_4);
	            log.debug("e_sc_no :"  + scNo_5);
                log.debug("e_sc_no :" + scNo_5);            
			    log.debug("eai_date:" + eaiDate_11);           

				if(mapVO.size() > 0){//if-4

 					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new EDISetupDBDAODeleteEdiGrpCustDSQL(), param, velParam);
 						if(insCnt == Statement.EXECUTE_FAILED)
 							throw new DAOException("Fail to Delete No["+ i + "] at SQL: EDISetupDBDAODeleteEdiGrpCustDSQL");
 				}//if-4
       }//if
	} catch (SQLException se) {
		log.error(se.getMessage(), se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	} catch (Exception ex) {
		log.error(ex.getMessage(), ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	}//for
	}

	/** null 값을 변경한다.
	 * @param String arg1
	 * @param String arg2
	 * @return String
	 */
	public String getNullValue(String arg1, String arg2){
		arg1 = JSPUtil.getNull(arg1);
		if(arg1.equals("")){
			arg1 = arg2;
		}
		return arg1;
	}
	
}
