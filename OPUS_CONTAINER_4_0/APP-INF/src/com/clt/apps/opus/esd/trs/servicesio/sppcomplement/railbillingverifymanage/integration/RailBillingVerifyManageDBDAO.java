/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAO.java
*@FileTitle : Rail Billing Verify
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
* N200902050101 2009-02-12 WRS CN ACTIVATION REEFER BLOCK 로직 추가
* S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
* N200907240070 2009-09-29 미주 Rail Billing CA 지역 Rail Billing Block 적용 보완
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.clt.apps.opus.esd.trs.servicesio.common.util.HashMapEnumeration;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event.RailBillingVerifyEvent;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event.RailBillingVerifyList;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo 
 * @see RailBillingVerifyManageBCImpl 참조
 * @since J2EE 1.4
 */
public class RailBillingVerifyManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * RailBillingVerifyManage의 Full 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public Collection checkFullContainerStatusFirst(RailBillingVerifyEvent event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet rsMdmYard = null;
		DBRowSet rsCopCntrMst = null;
		DBRowSet rsCntrMvmt = null;
		DBRowSet rsCntrMvmt2 = null;
		DBRowSet rsNisRailSo = null;
		DBRowSet rsCopPol = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		RailBillingVerifyList[] arrEventRailBillingVerifyList = event.getRailBillingVerifyList();
				
		String eBkgNo = event.getBkg_no();
		String eToYardCd = event.getTo_yd_cd();
		
		try{
			/* FULL 1-6. MDM YARD 추가건. */ 
			if(eToYardCd == null || eToYardCd.equals("") ){throw new Exception("YD_CD is mandatory.");}
			
			param.put("toYardCd", eToYardCd);
			velParam.put("toYardCd", eToYardCd);
			
			rsMdmYard = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstYardRSQL(), param, velParam);
			
			String ydFctyTpMrnTmlFlg = "";
			
			if(rsMdmYard != null && rsMdmYard.next()) {	
				if(rsMdmYard.getString("YD_FCTY_TP_MRN_TML_FLG") != null && !rsMdmYard.getString("YD_FCTY_TP_MRN_TML_FLG").equals("")) {
					ydFctyTpMrnTmlFlg = rsMdmYard.getString("YD_FCTY_TP_MRN_TML_FLG"); 	
				}
			}	// MDM YARD end	
			
			Collection models = new ArrayList();  	
			for( int i = 0 ; i < arrEventRailBillingVerifyList.length; i++ ) {
				
				RailBillingVerifyList railbillingverifyList = new RailBillingVerifyList();
				
				railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOWRS);	// 초기값  NO WRS : 2
				railbillingverifyList.setLang_tp_cd("ENG");						// Error Message : "language"	
				railbillingverifyList.setErr_msg_cd("TRS00031");				// Error Message : "Invalid container No"
				
				String eCntrTpSzCd 	= "";
				
				if(arrEventRailBillingVerifyList[i].getEq_tpsz_cd().trim().equals("D4")||arrEventRailBillingVerifyList[i].getEq_tpsz_cd().trim().equals("D5")) {	
					eCntrTpSzCd = "D45"; 
				}else{
					eCntrTpSzCd = arrEventRailBillingVerifyList[i].getEq_tpsz_cd().trim();					
				} 
				
				if(arrEventRailBillingVerifyList[i].getEq_no() != null && !arrEventRailBillingVerifyList[i].getEq_no().equals("") ){
					railbillingverifyList.setEq_no(arrEventRailBillingVerifyList[i].getEq_no().trim());
				}else{
	    			throw new Exception("CONTAINER_NO is mandatory.");
				}
				
				if(arrEventRailBillingVerifyList[i].getEq_tpsz_cd() != null && !arrEventRailBillingVerifyList[i].getEq_tpsz_cd().equals("") ){
					railbillingverifyList.setEq_tpsz_cd(arrEventRailBillingVerifyList[i].getEq_tpsz_cd().trim());     			
				}else{
	    			throw new Exception("EQ TYPE SIEZ CODE SIZE is mandatory.");
				}
				
				if(arrEventRailBillingVerifyList[i].getEq_tpsz_nm() != null && !arrEventRailBillingVerifyList[i].getEq_tpsz_nm().equals("") ){//Eq_tpsz_nm 세팅.
					railbillingverifyList.setEq_tpsz_nm(arrEventRailBillingVerifyList[i].getEq_tpsz_nm().trim());
				}
				
				if(arrEventRailBillingVerifyList[i].getBlk_flg() != null && !arrEventRailBillingVerifyList[i].getBlk_flg().equals("") ){
					railbillingverifyList.setBlk_flg(arrEventRailBillingVerifyList[i].getBlk_flg().trim());          							// 이하 테이블에서 확인 하는 로직 정의 안됨
				}
				
				if(arrEventRailBillingVerifyList[i].getStl_wire_flg() != null && !arrEventRailBillingVerifyList[i].getStl_wire_flg().equals("") ){
					railbillingverifyList.setStl_wire_flg(arrEventRailBillingVerifyList[i].getStl_wire_flg().trim()); 
				}
				
				if(arrEventRailBillingVerifyList[i].getCoil_shp_flg() != null && !arrEventRailBillingVerifyList[i].getCoil_shp_flg().equals("") ){
					railbillingverifyList.setCoil_shp_flg(arrEventRailBillingVerifyList[i].getCoil_shp_flg().trim());	
				}
				
				if(arrEventRailBillingVerifyList[i].getFmgt_flg() != null && !arrEventRailBillingVerifyList[i].getFmgt_flg().equals("") ){
					railbillingverifyList.setFmgt_flg(arrEventRailBillingVerifyList[i].getFmgt_flg().trim());
				}
				
				if(arrEventRailBillingVerifyList[i].getPiece() != null && !arrEventRailBillingVerifyList[i].getPiece().equals("") ){
					railbillingverifyList.setPiece(arrEventRailBillingVerifyList[i].getPiece().trim());
				}
				
				if(arrEventRailBillingVerifyList[i].getWeight() != null && !arrEventRailBillingVerifyList[i].getWeight().equals("") ){ 				//추가20070521. container weight
					railbillingverifyList.setWeight(arrEventRailBillingVerifyList[i].getWeight().trim());
				}else{
	    			throw new Exception("CONTAINER WEIGHT is mandatory.");
				}
				
				param.put("bkgNo", eBkgNo);
				velParam.put("bkgNo", eBkgNo);
				
				param.put("eqNo", arrEventRailBillingVerifyList[i].getEq_no().trim());
				velParam.put("eqNo", arrEventRailBillingVerifyList[i].getEq_no().trim());
								
				rsCopCntrMst = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstCntrRSQL(), param, velParam);
				
				String pctlNo = "";
				
				if(rsCopCntrMst != null && rsCopCntrMst.next()) {
					if(rsCopCntrMst.getString("PCTL_NO") != null && !rsCopCntrMst.getString("PCTL_NO").equals("")) {
						pctlNo = rsCopCntrMst.getString("PCTL_NO"); 	
						railbillingverifyList.setPctlNo(pctlNo);
					}
												
					// FULL 1-1. CONTAINER INFORMATION CHECK
					if(rsCopCntrMst.getString("CONTAINER_NO") != null && !rsCopCntrMst.getString("CONTAINER_NO").equals("") ){
						railbillingverifyList.setEq_no(rsCopCntrMst.getString("CONTAINER_NO"));
					}
					
					if(rsCopCntrMst.getString("CONTAINER_TP_SZ") != null && !rsCopCntrMst.getString("CONTAINER_TP_SZ").equals("")
						&& rsCopCntrMst.getString("CONTAINER_TP_SZ").equals(eCntrTpSzCd)){ 						
						railbillingverifyList.setEq_tpsz_cd(arrEventRailBillingVerifyList[i].getEq_tpsz_cd().trim()); 		//D4, D5일경우는 D45('XY')이기때문에 원래받은  타입사이즈로  SETTING .	
					}
					
				    if(rsCopCntrMst.getString("CONTAINER_NO") 				== null || rsCopCntrMst.getString("CONTAINER_NO").equals("") )		{railbillingverifyList.setErr_msg_cd("TRS00031");	//"Invalid container No"
				    }else if(rsCopCntrMst.getString("CONTAINER_TP_SZ") 	== null || rsCopCntrMst.getString("CONTAINER_TP_SZ").equals("")	|| !rsCopCntrMst.getString("CONTAINER_TP_SZ").equals(eCntrTpSzCd) ){railbillingverifyList.setErr_msg_cd("TRS00034");	//"A mismatch of container No and type/size"												
					}else if(rsCopCntrMst.getString("IS_SOC") 			!= null && rsCopCntrMst.getString("IS_SOC").equals("Y")) 			{ railbillingverifyList.setErr_msg_cd("TRS00018");	//"The rail billing can not be submitted through this portal site. \nPlease fax or e-mail to Hanjin Phoenix office for this rail billing request.\nE-mail : railbilling@us.hanjin.com  / Fax : 480-820-0135" 		
					}else if(rsCopCntrMst.getString("IS_ACTIVE") 			!= null && rsCopCntrMst.getString("IS_ACTIVE").equals("N")) 		{ railbillingverifyList.setErr_msg_cd("TRS00035"); 	//"Inactive container status" 
					}else if(rsCopCntrMst.getString("IS_US_REGION") 		!= null && rsCopCntrMst.getString("IS_US_REGION").equals("N")) 		{ railbillingverifyList.setErr_msg_cd("TRS00032");	//"Unavailable container No in US Region"
					}else if(rsCopCntrMst.getString("IS_DAMAGED") 		!= null && rsCopCntrMst.getString("IS_DAMAGED").equals("Y")) 		{ railbillingverifyList.setErr_msg_cd("TRS00036");  //"Damaged CNTR. Please send a request to railbilling@us.hanjin.com"
					}else if(rsCopCntrMst.getString("IS_LEASE_EXPIRED") 	!= null && rsCopCntrMst.getString("IS_LEASE_EXPIRED").equals("Y")) 	{ railbillingverifyList.setErr_msg_cd("TRS00029");	 //"One way free lease container."
					/** "GOOD" Billing  */
					}else{	
						railbillingverifyList.setErr_msg_cd("");
						railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_GOOD);			//"GOOD" billing	["0"]				
					}
				    
					//	Full
				    /******************************************************************************
				     * "GOOD" Billing의 경우 COP_NO+COST_ACT_GRP_SEQ Setting in event object.
				     * 
				     */
				    if(railbillingverifyList.getErr_msg_cd() == null || railbillingverifyList.getErr_msg_cd().equals("")) {	// 추가 2007.04.12
				    	if(rsCopCntrMst.getString("COP_NO") 			!= null && !rsCopCntrMst.getString("COP_NO").equals("") )			{railbillingverifyList.setCop_no(rsCopCntrMst.getString("COP_NO"));}
				    	if(rsCopCntrMst.getString("COST_ACT_GRP_SEQ") 	!= null && !rsCopCntrMst.getString("COST_ACT_GRP_SEQ").equals("") )	{railbillingverifyList.setCost_act_grp_seq(rsCopCntrMst.getString("COST_ACT_GRP_SEQ"));}
				    }
				    
				    if(rsCopCntrMst.getString("TARE_WGT") != null && !rsCopCntrMst.getString("TARE_WGT").equals("")){
						railbillingverifyList.setTare_wgt(rsCopCntrMst.getString("TARE_WGT")); 		//D4, D5일경우는 D45('XY')이기때문에 원래받은  타입사이즈로  SETTING .	
				    }
				}				
				
				// FULL 1-2. MVMT STATUS CHECK
				if(railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("")) {
					
					rsCntrMvmt = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstMvntRSQL(), param, velParam);
					
					if(rsCntrMvmt != null && rsCntrMvmt.next()) {																
						
						// MTY 2-2-1. MVMT STATUS CHECK (EN or TN 일때. 최종상태)
						if(((rsCntrMvmt.getString("IS_CORRECT_ENTN") != null && rsCntrMvmt.getString("IS_CORRECT_ENTN").equals("EN")))||
						   ((rsCntrMvmt.getString("IS_CORRECT_ENTN") != null && rsCntrMvmt.getString("IS_CORRECT_ENTN").equals("TN")))) { //EN, TN :운송중인 상태일 경우, 최종상태 체크
							
							String sCntrMvmtCorrectEnTn = rsCntrMvmt.getString("IS_CORRECT_ENTN");
							
							param.put("eEqNo", rsCntrMvmt.getString("CNTR_NO"));
							velParam.put("eEqNo", rsCntrMvmt.getString("CNTR_NO"));
									
							rsCntrMvmt2 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstMvnt2RSQL(), param, velParam);
							
							/**
							 * Container Movement Check하여 WRS Verify Result Re-Setting
							 */							
							if(rsCntrMvmt2 != null && rsCntrMvmt2.next()) {
								if((		rsCntrMvmt2.getString("IS_CORRECT_MVMT") != null && rsCntrMvmt2.getString("IS_CORRECT_MVMT").equals("Y")) 
										|| 	rsCntrMvmt2.getString("IS_CORRECT_MVMT") != null && rsCntrMvmt2.getString("IS_CORRECT_MVMT").equals(sCntrMvmtCorrectEnTn)) { // ID, MT, OP, OC, EN or TN : good
											railbillingverifyList.setErr_msg_cd("");				//"GOOD" ["0"]	billing Setting
								}else{ 	railbillingverifyList.setErr_msg_cd("TRS00027"); }		//"NOWRS"["2"]	billing Setting >> "Improper container location for the rail billing request. Please contact HJS Phoenix for further info."
							}							
							
						//	MTY 2-2-2. MVMT STATUS CHECK2 (EN, TN 아닐때. 최종 상태)		
						}else{
							
							param.put("eEqNo", rsCntrMvmt.getString("CNTR_NO"));
							velParam.put("eEqNo", rsCntrMvmt.getString("CNTR_NO"));
							
							rsCntrMvmt2 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstMvnt2RSQL(), param, velParam);
							
							if(rsCntrMvmt2 != null && rsCntrMvmt2.next()) {
								if(rsCntrMvmt2.getString("IS_CORRECT_MVMT") != null && rsCntrMvmt2.getString("IS_CORRECT_MVMT").equals("Y")){ // ID, MT, OP, OC : good
											railbillingverifyList.setErr_msg_cd("");			//"GOOD" ["0"]	billing Setting :: "OP"+"OC"+"ID"+"MT"
								}else{ 	railbillingverifyList.setErr_msg_cd("TRS00027"); }	//"NOWRS"["2"]	billing Setting >> "Improper container location for the rail billing request. Please contact HJS Phoenix for further info."
							}							
						}
					}					
				}
														
				/* FULL . 추가 변경. BKG CHECK -- SEN, HJL RAIL BILLING CHECK  */ 
				if (railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("")) {
					
					rsNisRailSo = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstDupRSQL(), param, velParam);
					
					if (rsNisRailSo != null && rsNisRailSo.next()) {						
						//	CHECK 에서 VERIFY_YN  
						if (rsNisRailSo.getString("VERIFY_YN") != null && rsNisRailSo.getString("VERIFY_YN").equals("Y")) {			// 에러 메세지 정의 필요	
							if (rsNisRailSo.getString("CXL_RQST") != null && rsNisRailSo.getString("CXL_RQST").equals("Y")) {  		// VRFY : Y , CXL_FLG : Y
					    		railbillingverifyList.setErr_msg_cd("TRS00054");  	//"GOOD" ??
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);								
							} else {																								// VRFY : Y , CXL_FLG : N
								railbillingverifyList.setErr_msg_cd("TRS00026"); 	//"Duplicated rail billing. Please contact HJS Pheonix for further info."
							}
					    } else if (rsNisRailSo.getString("VERIFY_YN") != null && rsNisRailSo.getString("VERIFY_YN").equals("N")) {
					    	if (rsNisRailSo.getString("CXL_RQST") != null && rsNisRailSo.getString("CXL_RQST").equals("Y")) {		// VRFY : N , CXL_FLG : Y
					    		// CXL RQST 가 24시간 내 존재시 54번 에러코드 리턴
					    		railbillingverifyList.setErr_msg_cd("TRS00054");  	//"GOOD" ??
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);								
					    	} else {																								// VRFY : N , CXL_FLG : N
						    	railbillingverifyList.setErr_msg_cd("TRS00037");	//"GOOD" ??
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);	
					    	}
						} else {
							railbillingverifyList.setErr_msg_cd("");				
							railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_GOOD);					
						}
					}
				}	
				
				/* FULL 1-6. MDM YARD 추가건. */ 
				if (railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("")) {											
					railbillingverifyList.setYd_fcty_tp_mrn_tml_flg(ydFctyTpMrnTmlFlg);
				}// MDM YARD end
				
				/* FULL 1-7. US region check. 추가건. (20070702) */ 
				if (railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("")) {
					
					rsCopPol = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstRegionRSQL(), param, velParam);
					
					if (rsCopPol != null && rsCopPol.next()) {
						if( rsCopPol.getString("POL") != null && !rsCopPol.getString("POL").equals("")) { railbillingverifyList.setUs_region(rsCopPol.getString("POL"));}																											
					}
				}				
				models.add(railbillingverifyList);				
			}	//END OUTER FOR.
			return models;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
	}
	

	/**
	 * RailBillingVerifyManage의 Full 모든 목록을 가져온다.<br>
	 * 
	 * @param models
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public Collection checkFullContainerStatusSecond(Collection models, RailBillingVerifyEvent event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet rs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		RailBillingVerifyList[] eRailBillingVerifyList = event.getRailBillingVerifyList();
		
		String eBkgNo = event.getBkg_no();
		
		String rBzcSts = event.getBzc_sts();
		String rErrMsgCd = event.getErr_msg_cd();
		String rLangTpCd = event.getLang_tp_cd();
		
		try{
			
			HashMapEnumeration hmCntrAssistList = new HashMapEnumeration();
			
			/* FULL 1-8. (더미 cntr) 해당booking의 CNTR_TPSZ_CD를 키로 cop_no 매핑시켜 임시저장. railbillingverifyList . */
			for( int i = 0 ; i < eRailBillingVerifyList.length ; i++) {
				String eCntrTpSzCd 	= "";
				if(eRailBillingVerifyList[i].getEq_tpsz_cd() != null && (eRailBillingVerifyList[i].getEq_tpsz_cd().trim().equals("D4")||eRailBillingVerifyList[i].getEq_tpsz_cd().trim().equals("D5"))){
					eCntrTpSzCd 		= "D45"; 
				}else{
					eCntrTpSzCd 		= eRailBillingVerifyList[i].getEq_tpsz_cd() != null ? eRailBillingVerifyList[i].getEq_tpsz_cd().trim() : "";					
				} 
				
				if( !hmCntrAssistList.containsKey(eRailBillingVerifyList[i].getEq_tpsz_cd()+"-0") ) {
					
					param.put("bkgNo", eBkgNo);
					velParam.put("bkgNo", eBkgNo);
					
					param.put("eqTpSzCd", eCntrTpSzCd);
					velParam.put("eqTpSzCd", eCntrTpSzCd);
					
					rs = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckFullContainerStatusSecondCopRSQL(), param, velParam);
					
					int z = 0;
					
					while (rs != null && rs.next()) {		/* First Row Selection	*/
		            	RailBillingVerifyList railbillingverifyList = new RailBillingVerifyList();             
						railbillingverifyList.setCop_no				(rs.getString("COP_NO")								);           
						railbillingverifyList.setCost_act_grp_seq	(rs.getString("COST_ACT_GRP_SEQ")					);  						
		            	railbillingverifyList.setEq_tpsz_cd			(eRailBillingVerifyList[i].getEq_tpsz_cd()			);
		            	railbillingverifyList.setHt_key				(eRailBillingVerifyList[i].getEq_tpsz_cd()+"-"+z++	);
		            	
		            	hmCntrAssistList.put(railbillingverifyList.getHt_key(), railbillingverifyList);
		            }
				}	
			}		
			
			// FULL 1-8-2. cop 가 매핑되어 있지 않을 경우만. CNTR_TPSZ_CD(를 키로)별로 위에서 매핑 시킨 cop를 asign.(이후 irg 매핑)
			Iterator itr = models.iterator();		
			
			while (itr.hasNext()) {
				RailBillingVerifyList railbillingverifyList  = (RailBillingVerifyList)itr.next();
				
				if (		railbillingverifyList.getErr_msg_cd() == null 					
						||	railbillingverifyList.getErr_msg_cd().equals("") 
						||	railbillingverifyList.getErr_msg_cd().equals("TRS00037")		//"GOOD"
						||	railbillingverifyList.getErr_msg_cd().equals("TRS00054") ) 		//"GOOD"
				{	

					// 1st 메소드에서 cop_no 를 매핑 못 했을때만..
					/********************************************************************************************
					 * COP_NO/COST_ACT_GRP_SEQ MAPPING.
					 */
					if(railbillingverifyList.getCop_no() == null || "".equals(railbillingverifyList.getCop_no())) {						
						RailBillingVerifyList railbillingverifyList2 	= null;
						Enumeration enList2 							= hmCntrAssistList.elements();	
						
						while(enList2 != null && enList2.hasMoreElements()) {
							RailBillingVerifyList oVO = (RailBillingVerifyList)enList2.nextElement();

							// 위에서 bkg_no,tpsz 로 갖고온 cntr_tpsz (ovO)하고 최초 대상의 cntr_tpsz 가 같으면 railbillingverifyList2 여기에 저장 후 
							if(oVO.getEq_tpsz_cd().equals(railbillingverifyList.getEq_tpsz_cd())) {
								railbillingverifyList2   = (RailBillingVerifyList)hmCntrAssistList.get(oVO.getHt_key());
								break;
							}
						}

						// 위에서 저장된 data 가 있으면 cop_no 할당.
						if (railbillingverifyList2 != null){
							railbillingverifyList.setCop_no				(railbillingverifyList2.getCop_no());
							railbillingverifyList.setCost_act_grp_seq	(railbillingverifyList2.getCost_act_grp_seq());	
							
							hmCntrAssistList.remove(railbillingverifyList2.getHt_key());
						}						
					}
				}	//END OF IF.					
			}		//END OF WHILE.
			
				
			//Full 최종 1-9. 해당 cntr_no가  good인 경우. 넘어온 flg, weight 등 최종 체크 
			for( Iterator itr2 = models.iterator();	itr2.hasNext(); ) {
				RailBillingVerifyList railbillingverifyList = (RailBillingVerifyList)itr2.next();
				
				if ( railbillingverifyList.getErr_msg_cd() == null || railbillingverifyList.getErr_msg_cd().equals("") ) {	
					
					if( !(railbillingverifyList.getCop_no() == null || "".equals(railbillingverifyList.getCop_no())) ) {
						
					    if ( rBzcSts != null && rBzcSts.equals("0") ){
					    	
						    if (	railbillingverifyList.getBlk_flg() != null 
						    	&& 	railbillingverifyList.getBlk_flg().equals("Y")){									//BULK CARGO : "NOGOOD"		    	
						    	railbillingverifyList.setErr_msg_cd("TRS00020");			//"'Bulk' or 'Hide' cargo. Manual treatment by HJS Pheonix once submitted."
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);							
							} else if (		railbillingverifyList.getStl_wire_flg() != null 
										&& 	railbillingverifyList.getStl_wire_flg().equals("Y")){						//STEEL WIRE : "NOGOOD"
								railbillingverifyList.setErr_msg_cd("TRS00021");			//"Steel' or 'Fumigation' cargo. Manual treatment by HJS Pheonix once submitted."
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);
							} else if (		railbillingverifyList.getCoil_shp_flg() != null 
										&&	railbillingverifyList.getCoil_shp_flg().equals("Y")){						//COIL SHIP  : "NOGOOD"
								railbillingverifyList.setErr_msg_cd("TRS00021");			//"Steel' or 'Fumigation' cargo. Manual treatment by HJS Pheonix once submitted."
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);
							} else if (		railbillingverifyList.getFmgt_flg() != null 
										&&	railbillingverifyList.getFmgt_flg().equals("Y")){							//FMGT       : "NOGOOD"
								railbillingverifyList.setErr_msg_cd("TRS00021");			//"Steel' or 'Fumigation' cargo. Manual treatment by HJS Pheonix once submitted."
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);							
							} else if (railbillingverifyList.getUs_region().equals("CA")
									&& railbillingverifyList.getEq_tpsz_cd().equals("D2")
									&&	Integer.parseInt(railbillingverifyList.getWeight()) > 50000) {								
									railbillingverifyList.setErr_msg_cd("TRS00047");	// "Overweight cargo.Manual treatment by HJS Pheonix once submitted."
									railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);	
							} else if(railbillingverifyList.getUs_region().equals("CA")
									&& (railbillingverifyList.getEq_tpsz_cd().equals("D4") 
											|| railbillingverifyList.getEq_tpsz_cd().equals("D5") 
											|| railbillingverifyList.getEq_tpsz_cd().equals("D7"))
									&& Integer.parseInt(railbillingverifyList.getWeight()) > 60000){				// ALL CNTR + WEIGHT>60000(LBS)    : "NOGOOD"
									railbillingverifyList.setErr_msg_cd("TRS00047");	// "Overweight cargo.Manual treatment by HJS Pheonix once submitted."
									railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);							
							} else if (railbillingverifyList.getUs_region().equals("US")) { 							// pol = us check (2007.07.02)
								
								if (	railbillingverifyList.getYd_fcty_tp_mrn_tml_flg() != null 
										&& railbillingverifyList.getYd_fcty_tp_mrn_tml_flg().equals("Y")){ 				//추가 20070521 WHIGHT, TO_YARD
									if (		railbillingverifyList.getEq_tpsz_cd().substring(1,2).equals("2")
											&&	Integer.parseInt(railbillingverifyList.getWeight()) > 44000) {			//CNTR SIZE:2 + WEIGHT>39000(LBS) : "NOGOOD"
										railbillingverifyList.setErr_msg_cd("TRS00047");	//"Overweight cargo.Manual treatment by HJS Pheonix once submitted."
										railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);	
									} else if(Integer.parseInt(railbillingverifyList.getWeight()) > 50000){				//ALL CNTR + WEIGHT>45000(LBS)    : "NOGOOD"
										railbillingverifyList.setErr_msg_cd("TRS00047");	//"Overweight cargo.Manual treatment by HJS Pheonix once submitted."
										railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);	
										
									}
								} else if (		railbillingverifyList.getYd_fcty_tp_mrn_tml_flg() != null 
											&&	railbillingverifyList.getYd_fcty_tp_mrn_tml_flg().equals("N")){ 		//추가 20070521 WHIGHT, TO_YARD
									if (		railbillingverifyList.getEq_tpsz_cd().substring(1,2).equals("2")
											&&	Integer.parseInt(railbillingverifyList.getWeight()) > 38000){
										railbillingverifyList.setErr_msg_cd("TRS00047");	//"Overweight cargo.Manual treatment by HJS Pheonix once submitted."
										railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);	
									} else if(Integer.parseInt(railbillingverifyList.getWeight()) > 44000){
										railbillingverifyList.setErr_msg_cd("TRS00047");	//"Overweight cargo.Manual treatment by HJS Pheonix once submitted."
										railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);	
									}
								}		
								
							}else {
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_GOOD);	//"GOOD"
							}			    
						    
						//  1 이나 이외 모두 : 비정상    
					    } else if (rBzcSts != null && rBzcSts.equals("1")){
							railbillingverifyList.setErr_msg_cd(rErrMsgCd);
							railbillingverifyList.setLang_tp_cd(rLangTpCd);
							railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);		//"NOGOOD"										
						} else {
							railbillingverifyList.setErr_msg_cd(rErrMsgCd);
							railbillingverifyList.setLang_tp_cd(rLangTpCd);
							railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);		//"NOGOOD"
						}	//END OF IF.
					    
					} else {
						railbillingverifyList.setErr_msg_cd("TRS00041");		//"This container is attached to a different booking."
					}		//END OF IF.			    
				}			//END OF IF.
			}				//END OF FOR.
			
			// Export Available Cargo Return Time Verify 쿼리.
			/*
			 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
			 */
			int i = 0;
			for(Iterator itr3 = models.iterator();	itr3.hasNext();){
				RailBillingVerifyList railbillingverifyList = (RailBillingVerifyList)itr3.next();
					
				param.put("vndrSeq", eRailBillingVerifyList[i].getVndr_seq());
				velParam.put("vndrSeq", eRailBillingVerifyList[i].getVndr_seq());
				
				param.put("bkgNo", eBkgNo);
				velParam.put("bkgNo", eBkgNo);
				
				param.put("eqNo", eRailBillingVerifyList[i].getEq_no().trim());
				velParam.put("eqNo", eRailBillingVerifyList[i].getEq_no().trim());
					
				rs = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckFullContainerStatusSecondReturnTimeRSQL(), param, velParam);
				
				while(rs != null && rs.next()){
					/*
					 * N200907240070 2009-09-29 미주 Rail Billing CA 지역 Rail Billing Block 적용 보완
					 */
					if("USSEA".equals(rs.getString(3)) || "USPDX".equals(rs.getString(3))){
						if("R".equals(rs.getString(4)) && rs.getInt(1) > 0){
							railbillingverifyList.setErr_msg_cd("TRS50110");
							railbillingverifyList.setErr_msg("Can not create S/O before " + rs.getString(2) 
									+ " If you have any question, please call to 1-800-866-RAILBIL or e-mail to railbilling@us.hanjin.com");							
						}
					}else{
						if(rs.getInt(1) > 0 && !"CA".equals(rs.getString(3).substring(0, 2))){
							railbillingverifyList.setErr_msg_cd("TRS50110");
							railbillingverifyList.setErr_msg("Can not create S/O before " + rs.getString(2) 
									+ " If you have any question, please call to 1-800-866-RAILBIL or e-mail to railbilling@us.hanjin.com");
						}  
					}							
				}
				i++;				
			}							
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
		return models; 
	}
	
	
	/**
	 * RailBillingVerifyManage의 Full 모든 목록을 가져온다.<br>
	 * 
	 * @param sCntrNo
	 * @return
	 * @throws DAOException
	 */
	public String checkFullContainerForMtyCancelHistory(String	sCntrNo) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet rsMtyCntrCancelHist = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String strWRSVerifyResultCd	= null;		
		
		try{
			param.put("eqNo", sCntrNo);
			velParam.put("eqNo", sCntrNo);
			
			rsMtyCntrCancelHist = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckFullContainerForMtyCancelHistoryRSQL(), param, velParam);
			
			if(rsMtyCntrCancelHist.next() && Integer.parseInt(rsMtyCntrCancelHist.getString("MTY_CANCEL_CNT"))>0)	strWRSVerifyResultCd = Constants.VRFY_NOBILLING;
			else strWRSVerifyResultCd = "";								
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}	
		return strWRSVerifyResultCd; 
	}
	
	
	/**
	 * RailBillingVerifyManage의 Mty 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public Collection checkMtyContainerStatus(RailBillingVerifyEvent event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet rs = null;
		DBRowSet rs2 = null;
		DBRowSet rs3 = null;
		DBRowSet rsWh = null;
		DBRowSet rs6 = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		RailBillingVerifyList[] rRailBillingVerifyList = event.getRailBillingVerifyList();
		
		String rFmYdCd = "";
		if(event.getFm_yd_cd()!= null){
			rFmYdCd = event.getFm_yd_cd();
		}
		
		try{
			
			Collection models = new ArrayList();
			
			for( int z = 0 ; z < rRailBillingVerifyList.length ; z++) {
				RailBillingVerifyList railbillingverifyList = new RailBillingVerifyList();
				railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOWRS);				// 초기값  NO Good
				railbillingverifyList.setLang_tp_cd("ENG");									// language							
				railbillingverifyList.setErr_msg_cd("TRS00031");
				
				if(rRailBillingVerifyList[z].getEq_no() != null && !rRailBillingVerifyList[z].getEq_no().equals("") ){
					railbillingverifyList.setEq_no(rRailBillingVerifyList[z].getEq_no().trim());
				}else{
	    			throw new Exception("CONTAINER_NO is mandatory.");
				}
				
				if(rRailBillingVerifyList[z].getEq_tpsz_cd() != null && !rRailBillingVerifyList[z].getEq_tpsz_cd().equals("") ){
					railbillingverifyList.setEq_tpsz_cd(rRailBillingVerifyList[z].getEq_tpsz_cd().trim());     			
				}else{
	    			throw new Exception("EQ TYPE SIZE CODE is mandatory.");
				}
				
				if(rRailBillingVerifyList[z].getEq_tpsz_nm() != null && !rRailBillingVerifyList[z].getEq_tpsz_nm().equals("") ){//Eq_tpsz_nm 세팅.
					railbillingverifyList.setEq_tpsz_nm(rRailBillingVerifyList[z].getEq_tpsz_nm().trim());
				}
				
//				if(rFmYdCd == null && rFmYdCd.equals("") ){
				if(rFmYdCd.equals("") ){
	    			throw new Exception("FROM YARD CODE is mandatory.");
				}
				
				param.put("eqNo", rRailBillingVerifyList[z].getEq_no().trim());
				velParam.put("eqNo", rRailBillingVerifyList[z].getEq_no().trim());
				
				rs = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckMtyContainerStatusCntrRSQL(), param, velParam);
			   	
				String rsCntrTpszCd=null;
				
				// ETY 2-1. CONTAINER INFORMATION CHECK 
				if (rs != null && rs.next()) {	
					if (rs.getString("CONTAINER_NO") != null && !rs.getString("CONTAINER_NO").equals("") ){
						railbillingverifyList.setEq_no(rs.getString("CONTAINER_NO"));
					}
					
					rsCntrTpszCd = rs.getString("CONTAINER_TP_SZ");
					
				    if ( rsCntrTpszCd != null && !rs.getString("CONTAINER_TP_SZ").equals("")
						&& rsCntrTpszCd.equals(rRailBillingVerifyList[z].getEq_tpsz_cd().trim()) ){ 
				    	railbillingverifyList.setEq_tpsz_cd( rsCntrTpszCd );
				    	
				    	/* mt rail wrs 가능한 TPSZ 가 아니면 TPSZ Mistmatch 에러 */
				    	if (!( rsCntrTpszCd.equals("D2") || 
				    		   rsCntrTpszCd.equals("D4") || 
				    		   rsCntrTpszCd.equals("D5") || 
				    		   rsCntrTpszCd.equals("D7") || 
				    		   rsCntrTpszCd.equals("O2") || 
				    		   rsCntrTpszCd.equals("O4") || 
				    		   rsCntrTpszCd.equals("A2") || 
				    		   rsCntrTpszCd.equals("A4") ||
				    		   rsCntrTpszCd.equals("R2") || 
				    		   rsCntrTpszCd.equals("R5") ))
				    	{
							railbillingverifyList.setErr_msg_cd("TRS00345");			
				    	}
				    }
				    
					if (rs.getString("CONTAINER_NO") == null || rs.getString("CONTAINER_NO").equals("") ){
						railbillingverifyList.setErr_msg_cd("TRS00031");			
					} else if( rsCntrTpszCd == null || rsCntrTpszCd.equals("")
						|| !rsCntrTpszCd.equals(rRailBillingVerifyList[z].getEq_tpsz_cd().trim()) ){ 
						railbillingverifyList.setErr_msg_cd("TRS00034");															
					} else if (rs.getString("IS_SOC") != null && rs.getString("IS_SOC").equals("Y")) { railbillingverifyList.setErr_msg_cd("TRS00018"); 												
					} else if (rs.getString("IS_ACTIVE") != null && rs.getString("IS_ACTIVE").equals("N")) { railbillingverifyList.setErr_msg_cd("TRS00035");  											//확인요 미정
					} else if (rs.getString("IS_US_REGION") != null && rs.getString("IS_US_REGION").equals("N")) { railbillingverifyList.setErr_msg_cd("TRS00032"); 
					} else if (rs.getString("IS_DAMAGED") != null && rs.getString("IS_DAMAGED").equals("Y")) { railbillingverifyList.setErr_msg_cd("TRS00036");   											//확인요 미정 
					} else if (rs.getString("IS_LEASE_EXPIRED") != null && rs.getString("IS_LEASE_EXPIRED").equals("Y")) { railbillingverifyList.setErr_msg_cd("TRS00029"); 
					} else {
						railbillingverifyList.setErr_msg_cd("");
						railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_GOOD);							
					}					
				}
				
				// ETY 2-2. MVMT STATUS CHECK 
				if(railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("")){
					
					rs2 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckMtyContainerStatusMvntRSQL(), param, velParam);
					
					if(rs2 != null && rs2.next()) {																
						if(rs2.getString("IS_CORRECT_MVMT") != null && rs2.getString("IS_CORRECT_MVMT").equals("N")){ railbillingverifyList.setErr_msg_cd("TRS00027"); }											
					}
				}
				
				// ETY 2-3. BKG CHECK -- SEN, HJL RAIL BILLING CHECK 			
				if(railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("")) {
					
					rs3 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckMtyContainerStatusDupRSQL(), param, velParam);

					if (rs3 != null && rs3.next()) {
						if (rs3.getString("VERIFY_YN") != null && rs3.getString("VERIFY_YN").equals("Y")) {     
							if(rs3.getString("CXL_RQST") != null && rs3.getString("CXL_RQST").equals("Y")) {   // VRFY : Y , CXL_FLG : Y	WARNING
					    		railbillingverifyList.setErr_msg_cd("TRS00054");  
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);								
							}else{
								railbillingverifyList.setErr_msg_cd("TRS00026"); 								// VRFY : Y , CXL_FLG : N	Error
							}							
					    }else if(rs3.getString("VERIFY_YN") != null && rs3.getString("VERIFY_YN").equals("N")) {
							if(rs3.getString("CXL_RQST") != null && rs3.getString("CXL_RQST").equals("Y")) {	// VRFY : N , CXL_FLG : Y	Warning
					    		// CXL RQST 가 24시간 내 존재시 54번 에러코드 리턴
					    		railbillingverifyList.setErr_msg_cd("TRS00054");  
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);								
					    	}else{
						    	railbillingverifyList.setErr_msg_cd("TRS00037");								// VRFY : N , CXL_FLG : N   Warning 
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);	
					    	}
					    }else{
							railbillingverifyList.setErr_msg_cd("");
							railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_GOOD);							
						}
					}
				}	
				
				// ETY 2-5. EMPTY CNTR REPO_PLN_ID 
				if (railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("") 
					|| railbillingverifyList.getErr_msg_cd().equals("TRS00037")    // 2007.11.13 추가 by LYT. NO GOOD 일때 체크되어야하므로.
					|| railbillingverifyList.getErr_msg_cd().equals("TRS00054")
					) {
					
					param.put("fmYdCd", rFmYdCd);
					velParam.put("fmYdCd", rFmYdCd);
					
					param.put("eqTpSzCd", rRailBillingVerifyList[z].getEq_tpsz_cd().trim());
					velParam.put("eqTpSzCd", rRailBillingVerifyList[z].getEq_tpsz_cd().trim());
					
					rsWh = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckMtyContainerStatusPlanIdRSQL(), param, velParam);
					
					if (rsWh != null && rsWh.next()) {								
						if (rsWh.getString("REPO_PLN_ID") != null && !rsWh.getString("REPO_PLN_ID").equals("")){
							railbillingverifyList.setRepo_pln_id(rsWh.getString("REPO_PLN_ID")); 
							railbillingverifyList.setPln_yrwk(rsWh.getString("PLN_YRWK")); 
							railbillingverifyList.setRef_id(rsWh.getString("REF_ID"));	 					 
							railbillingverifyList.setRef_seq(rsWh.getString("REF_SEQ")); 	

							// ETY 2-6. EMPTY CNTR IRG  
							if ( rsWh.getString("TO_YD_CD") != null && !rsWh.getString("TO_YD_CD").equals("")
								&& ( rsWh.getString("FM_YD_CD") != null && !rsWh.getString("FM_YD_CD").equals("") )) {
								
								param.put("toYdCd", rsWh.getString("TO_YD_CD"));
								velParam.put("toYdCd", rsWh.getString("TO_YD_CD"));
									
								rs6 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckMtyContainerStatusIrgRSQL(), param, velParam);
																
								// BLOCK VENDOR 또는 S2R,S3R 만 체크하여 OK 이면 VERY_GOOD!								
								if (rs6 != null && rs6.next()) {																			
									if (rs6.getString("is_block_vendor").equals("Y") || rs6.getString("is_goodbill").equals("Y")) {  // is_block_vendor, is_goodbill NOWRS  
										railbillingverifyList.setErr_msg_cd("TRS00017");
										railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOWRS);																						
									} else {  // if (rs6.getString("is_constrainted").equals("N")) {   -- 2007.12.17 수정. CONSTRAINTED 로직 제거. BY 신희정. 
										railbillingverifyList.setRoute_org_nod_cd(rs6.getString("ROUT_ORG_NOD_CD")); 
										railbillingverifyList.setRoute_dest_nod_cd(rs6.getString("ROUT_DEST_NOD_CD")); 
										railbillingverifyList.setRoute_seq(rs6.getString("ROUT_SEQ"));   
										railbillingverifyList.setRail_route(rs6.getString("ROUTE"));   
										railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_GOOD);
									}
							    }
							}
						}
				    }// end rsWh							
				}// END ETY 2-5
				
				if (railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("")) {		
					railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_GOOD);
				}
				
				models.add(railbillingverifyList);
				
			} // end for
			return models;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}	 
	}
	
	
	/**
	 * RailBillingVerifyManage의 Mty 모든 목록을 가져온다.<br>
	 * 
	 * @param models
	 * @param event
	 * @param fm_yd_cd
	 * @return
	 * @throws DAOException
	 */
	public Collection checkMtyContainerStatusSe(Collection models, RailBillingVerifyEvent event, String fm_yd_cd) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet rsWh = null;
		DBRowSet rs6 = null;
		DBRowSet rs7 = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		RailBillingVerifyList[] rRailBillingVerifyList = event.getRailBillingVerifyList();
		
		try{
			
			HashMapEnumeration htCntrAssistList2 = new HashMapEnumeration();
			
			for( int z = 0 ; z < rRailBillingVerifyList.length ; z++) {				
				if(!htCntrAssistList2.containsKey(rRailBillingVerifyList[z].getEq_tpsz_cd()+"-0")) {
					
					param.put("fmYdCd", fm_yd_cd);
					velParam.put("fmYdCd", fm_yd_cd);
					
					param.put("eqNo", rRailBillingVerifyList[z].getEq_tpsz_cd());
					velParam.put("eqNo", rRailBillingVerifyList[z].getEq_tpsz_cd());
					
					// 1.해당 주차로 해당 cntr tpsz 에 대한 from node에 따른  plan 찾아 repo id 저장.
					rsWh = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrRSQL(), param, velParam);
					
					int yy = 0;
					while (rsWh != null && rsWh.next()) {	
						RailBillingVerifyList railbillingverifyList = new RailBillingVerifyList();   					
		            	railbillingverifyList.setRepo_pln_id(rsWh.getString("REPO_PLN_ID"));            
		            	railbillingverifyList.setPln_yrwk(rsWh.getString("PLN_YRWK"));           
		            	railbillingverifyList.setRef_id(rsWh.getString("REF_ID"));
		            	railbillingverifyList.setRef_seq(rsWh.getString("REF_SEQ"));
			            railbillingverifyList.setTo_yard(rsWh.getString("TO_YD_CD"));
		            	railbillingverifyList.setFm_yd_cd(rsWh.getString("FM_YD_CD"));
		            	railbillingverifyList.setEq_tpsz_cd(rRailBillingVerifyList[z].getEq_tpsz_cd());
		            	railbillingverifyList.setHt_key(rRailBillingVerifyList[z].getEq_tpsz_cd()+"-"+yy++);
		            	htCntrAssistList2.put(railbillingverifyList.getHt_key(), railbillingverifyList);
					}
				}
			}
			
			Enumeration enList = htCntrAssistList2.elements();			    // plan 데이터.
			
			HashMapEnumeration htCntrAssistList = new HashMapEnumeration();
			
			int aa = 0;
			
			String strFmYdCd = "";
			String strToYdCd = "";
			
			ArrayList currRoutList = null;
			
			while(enList != null && enList.hasMoreElements()) {		// cntr tpsz 별 해당 주차 plan 이 있다면..
				RailBillingVerifyList railbillingverifyList = (RailBillingVerifyList)enList.nextElement();				
				if (true) {
					// 2. 박힌 plan 의 IRG 체크. From, To, TPSZ 에 따른 IRG 유무에 따라  GOOD,NOGOOD,NOWRS 박아줌.
					// ETY 2-6. EMPTY CNTR IRG 
					if ( railbillingverifyList.getTo_yard() != null && !railbillingverifyList.getTo_yard().equals("")
						&& ( railbillingverifyList.getFm_yd_cd() != null && !railbillingverifyList.getFm_yd_cd().equals("") )) {
						
							if(rs6 == null || !strFmYdCd.equals(railbillingverifyList.getFm_yd_cd()) || !strToYdCd.equals(railbillingverifyList.getTo_yard())) {
								
								param.put("eFmYdCd", railbillingverifyList.getFm_yd_cd());
								velParam.put("eFmYdCd", railbillingverifyList.getFm_yd_cd());
								
								param.put("eToYard", railbillingverifyList.getTo_yard());
								velParam.put("eToYard", railbillingverifyList.getTo_yard());
								
								param.put("eEqTpSzCd", railbillingverifyList.getEq_tpsz_cd());
								velParam.put("eEqTpSzCd", railbillingverifyList.getEq_tpsz_cd());
								
								strFmYdCd = railbillingverifyList.getFm_yd_cd();
								strToYdCd = railbillingverifyList.getTo_yard();
								
								rs6 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrIrgRSQL(), param, velParam);
								
								currRoutList = new ArrayList();
								while(rs6 != null && rs6.next()) {
									RailBillingVerifyList railRoutList = new RailBillingVerifyList();
									railRoutList.setRoute_org_nod_cd(rs6.getString("ROUT_ORG_NOD_CD"));
									railRoutList.setRoute_dest_nod_cd(rs6.getString("ROUT_DEST_NOD_CD"));
									railRoutList.setRoute_seq(rs6.getString("ROUT_SEQ"));
									railRoutList.setRail_route(rs6.getString("ROUTE"));
									railRoutList.setIs_block_vendor(rs6.getString("IS_BLOCK_VENDOR"));
									railRoutList.setIs_goodbill(rs6.getString("IS_GOODBILL"));
									railRoutList.setIs_constrainted(rs6.getString("IS_CONSTRAINTED"));
									currRoutList.add(railRoutList);
								}
							}
							
							if (currRoutList != null && currRoutList.size() == 1) {	
								RailBillingVerifyList currRailRoutList = (RailBillingVerifyList)currRoutList.get(0);								

								// BLOCK VENDOR 또는 S2R,S3R 만 체크하여 OK 이면 VERY_GOOD!								
								if (currRailRoutList.getIs_block_vendor().equals("Y") || currRailRoutList.getIs_goodbill().equals("Y")) {  // is_block_vendor, is_goodbill NOWRS
									railbillingverifyList.setErr_msg_cd("TRS00017");
									railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOWRS);																						
								} else {   //if (currRailRoutList.getIs_constrainted().equals("N")) { 
									railbillingverifyList.setRoute_org_nod_cd(currRailRoutList.getRoute_org_nod_cd()); 
									railbillingverifyList.setRoute_dest_nod_cd(currRailRoutList.getRoute_dest_nod_cd()); 
									railbillingverifyList.setRoute_seq(currRailRoutList.getRoute_seq());  
									railbillingverifyList.setRail_route(currRailRoutList.getRail_route());  
									railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_GOOD);
								}	
							} else if (currRoutList != null && currRoutList.size() > 1) {
								if (railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("")) {
									RailBillingVerifyList currRailRoutList = (RailBillingVerifyList)currRoutList.get(0);
									railbillingverifyList.setRoute_org_nod_cd(currRailRoutList.getRoute_org_nod_cd()); 
									railbillingverifyList.setRoute_dest_nod_cd(currRailRoutList.getRoute_dest_nod_cd()); 
									railbillingverifyList.setRoute_seq(currRailRoutList.getRoute_seq());  
									railbillingverifyList.setRail_route(currRailRoutList.getRail_route());  
									railbillingverifyList.setErr_msg_cd("TRS00039");  // MULTI IRG
									railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOGOOD);			
								}
							} else {//TRS00042  ==> cntr 물량 있으나 no irg건.
								railbillingverifyList.setErr_msg_cd("TRS00042");  
							}
							
						}
					htCntrAssistList.put(railbillingverifyList.getHt_key(), railbillingverifyList);
					aa++;
				}//end if true
			}					

			Iterator itr = models.iterator();	
			while (itr.hasNext()) {
				RailBillingVerifyList railbillingverifyList3  = (RailBillingVerifyList)itr.next();	
				if (railbillingverifyList3.getErr_msg_cd()== null || railbillingverifyList3.getErr_msg_cd().equals("") 
					|| railbillingverifyList3.getErr_msg_cd().equals("TRS00037") 
					|| railbillingverifyList3.getErr_msg_cd().equals("TRS00054") 														
					&& ( railbillingverifyList3.getRepo_pln_id() == null 
						 || "".equals(railbillingverifyList3.getCop_no())  ) 
				   ) {
						RailBillingVerifyList railbillingverifyList2 = null;
						Enumeration enList2 = htCntrAssistList.elements();	
						// enList2 는 1번 PLAN 의 IRG 값에 대한  rs.
						// railbillingverifyList3 는  최초 넘어온 Verify 대상  CNTR 객체.					
						
						// 찾은 IRG 에서의 TPSZ 가 최초 Verify 대상 cntr_tpsz 와 같으면 당첨. 
						while(enList2 != null && enList2.hasMoreElements()) {
							RailBillingVerifyList oVO = (RailBillingVerifyList)enList2.nextElement();
							if(oVO.getEq_tpsz_cd().equals(railbillingverifyList3.getEq_tpsz_cd())) {
								railbillingverifyList2   = (RailBillingVerifyList)htCntrAssistList.get(oVO.getHt_key());
								break;
							}
						}
						if (railbillingverifyList2 != null){
							railbillingverifyList3.setRepo_pln_id(railbillingverifyList2.getRepo_pln_id());            
							railbillingverifyList3.setPln_yrwk(railbillingverifyList2.getPln_yrwk());           
							railbillingverifyList3.setRef_id(railbillingverifyList2.getRef_id());
							railbillingverifyList3.setRef_seq(railbillingverifyList2.getRef_seq());
							railbillingverifyList3.setRoute_org_nod_cd(railbillingverifyList2.getRoute_org_nod_cd());
							railbillingverifyList3.setRoute_dest_nod_cd(railbillingverifyList2.getRoute_dest_nod_cd());
							railbillingverifyList3.setRoute_seq(railbillingverifyList2.getRoute_seq());
							railbillingverifyList3.setRail_route(railbillingverifyList2.getRail_route());
							if(railbillingverifyList3.getErr_msg_cd() != null && !"".equals(railbillingverifyList3.getErr_msg_cd())) {
								if(Constants.VRFY_NOWRS.equals(railbillingverifyList2.getRailVrfyRstCd())) {
									railbillingverifyList3.setErr_msg_cd(railbillingverifyList2.getErr_msg_cd());
									railbillingverifyList3.setRailVrfyRstCd(railbillingverifyList2.getRailVrfyRstCd());		
								}													
							} else {
								railbillingverifyList3.setErr_msg_cd(railbillingverifyList2.getErr_msg_cd());
								railbillingverifyList3.setRailVrfyRstCd(railbillingverifyList2.getRailVrfyRstCd());							
							}
							htCntrAssistList.remove(railbillingverifyList2.getHt_key());
						}
					}
			}
			
			for(Iterator itr2 = models.iterator();	itr2.hasNext();) {
				RailBillingVerifyList railbillingverifyList = (RailBillingVerifyList)itr2.next();
								
				if (railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("")
						|| railbillingverifyList.getErr_msg_cd().equals("TRS00037")   // NO GOOD 조건들
						|| railbillingverifyList.getErr_msg_cd().equals("TRS00054")		
				) {	
					
					// 앞 메소드에서 IRG 가 매핑되어 있지 않다면..
					if (railbillingverifyList.getRoute_org_nod_cd() == null || railbillingverifyList.getRoute_org_nod_cd().equals("") ) {	
						railbillingverifyList.setErr_msg_cd("TRS00050");
							
						param.put("sFmYdCd", fm_yd_cd);
						velParam.put("sFmYdCd", fm_yd_cd);
						
						param.put("sEqTpSzCd", railbillingverifyList.getEq_tpsz_cd());
						velParam.put("sEqTpSzCd", railbillingverifyList.getEq_tpsz_cd());
						
						// rs7 은 3번재 쿼리로써,  IRG 체크. From NODE 별, TPSZ 별
						rs7 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrIrg2RSQL(), param, velParam);
						
						currRoutList = new ArrayList();
						while(rs7 != null && rs7.next()) {
							RailBillingVerifyList railRoutList = new RailBillingVerifyList();
							railRoutList.setRoute_org_nod_cd(rs7.getString("ROUT_ORG_NOD_CD"));
							railRoutList.setRoute_dest_nod_cd(rs7.getString("ROUT_DEST_NOD_CD"));
							railRoutList.setRoute_seq(rs7.getString("ROUT_SEQ"));
							railRoutList.setRail_route(rs7.getString("ROUTE"));
							railRoutList.setIs_block_vendor(rs7.getString("IS_BLOCK_VENDOR"));
							railRoutList.setIs_goodbill(rs7.getString("IS_GOODBILL"));
							railRoutList.setIs_constrainted(rs7.getString("IS_CONSTRAINTED"));
							currRoutList.add(railRoutList);
						}
						
						if (currRoutList != null && currRoutList.size() == 1) {	  /* IRG 가 1 개 있을때 */
							RailBillingVerifyList currRailRoutList = (RailBillingVerifyList)currRoutList.get(0);								
							if (currRailRoutList.getIs_block_vendor().equals("Y") || currRailRoutList.getIs_goodbill().equals("Y")) {  // is_block_vendor, is_goodbill NOWRS
								railbillingverifyList.setErr_msg_cd("TRS00017");
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOWRS);																						
							} else {
								railbillingverifyList.setRoute_org_nod_cd(currRailRoutList.getRoute_org_nod_cd()); 
								railbillingverifyList.setRoute_dest_nod_cd(currRailRoutList.getRoute_dest_nod_cd()); 
								railbillingverifyList.setRoute_seq(currRailRoutList.getRoute_seq());  
								railbillingverifyList.setRail_route(currRailRoutList.getRail_route());  
								railbillingverifyList.setErr_msg_cd("TRS00050");                 // EQR 오버플랜 호출관련, 수정부분.
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOWRS);
							}	
						} else if (currRoutList != null && currRoutList.size() > 1) {      /* MULTI IRG 일때.. */
							if (railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("TRS00050") ) {
								RailBillingVerifyList currRailRoutList = (RailBillingVerifyList)currRoutList.get(0);
								railbillingverifyList.setRoute_org_nod_cd(currRailRoutList.getRoute_org_nod_cd()); 
								railbillingverifyList.setRoute_dest_nod_cd(currRailRoutList.getRoute_dest_nod_cd()); 
								railbillingverifyList.setRoute_seq(currRailRoutList.getRoute_seq());  
								railbillingverifyList.setRail_route(currRailRoutList.getRail_route());  
								railbillingverifyList.setErr_msg_cd("TRS00053");  // MULTI IRG  새로 정의된 메시지 적용해야.
								railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOWRS);			
							}
						} else {//TRS00042  ==> overplan 대상이나, err msg 는 no irg 임.
							railbillingverifyList.setErr_msg_cd("TRS00042");  
						}
						
					}
					if (railbillingverifyList.getErr_msg_cd()== null || railbillingverifyList.getErr_msg_cd().equals("")) {		
						railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_GOOD);
					}
				} 
			}						
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
		return models; 
	}
	
/**
 * RailBillingVerifyManage의 Full 모든 목록을 가져온다.<br>
 * 
 * @return DBRowSet DB 처리 결과
 * @throws DAOException
 */
public String currDate() throws DAOException {
	// PDTO(Data Transfer Object including Parameters)
	DBRowSet dbRowset = null;
	String result = null;
	
	try{
		dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailBillingVerifyManageDBDAOCurrDateRSQL(), null, null);
		
		if (dbRowset != null && dbRowset.next()) {
			result = dbRowset.getString("CURR_DT");
		}
		
	} catch (SQLException se) {
		log.error(se.getMessage(), se);
		throw new DAOException(new ErrorHandler(se).getMessage(), se);
	} catch (Exception e) {
		log.error(e.getMessage(), e);
		throw new DAOException(new ErrorHandler(e).getMessage(), e);
	}	
	return result;
 }

}

