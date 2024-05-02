/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InputDataRlaExamineBCImpl.java
*@FileTitle : Input Data Red Light Alert 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-19
*@LastModifier : yongchan shin
*@LastVersion : 1.0
* 2006-10-19 yongchan shin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.integration.InputDataRlaExamineDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.EesEqr0003ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.InputDataRLAExamineRsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrEccLnkVO;
import com.hanjin.syscommon.common.table.EqrScnrEccVO;



/**
 * ALPS-InputDataRlaExamine Business Logic Basic Command implementation<br>
 * - ALPS-InputDataRlaExamine에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author yongchan shin
 * @see EES_EQR_003EventResponse,InputDataRlaExamineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class InputDataRlaExamineBCImpl   extends BasicCommandSupport implements InputDataRlaExamineBC {

	// Database Access Object
	private transient InputDataRlaExamineDBDAO dbDao=null;

	/**
	 * InputDataRlaExamineBCImpl 객체 생성<br>
	 * InputDataRlaExamineDBDAO를 생성한다.<br>
	 */
	public InputDataRlaExamineBCImpl(){
		dbDao = new InputDataRlaExamineDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_0003Event 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo EesEqr0003ConditionVO
	 * @param fromEccWhere String
	 * @param toEccWhere String
	 * @return InputDataRLAExamineRsVO
	 * @exception EventException
	 */
	public InputDataRLAExamineRsVO searchInputDataRLAList(EesEqr0003ConditionVO vo , String fromEccWhere , String toEccWhere) throws EventException {
		
		InputDataRLAExamineRsVO retVo		= null;
		
		try {
			retVo=dbDao.searchInputDataRLAList(vo, fromEccWhere, toEccWhere);
			
			return retVo;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	} 

	/**
     * 수정 이벤트 처리<br>
     * EES_EQR_0003 에 대한 추가 이벤트 처리<br>
     * 
	 * @param cvo EesDqr0003ConditionVO
	 * @param vos EqrScnrEccVO[]
	 * @param account SignOnUserAccount
     * @exception EventException
	 */
	public void modifyInputDataRLAList(EesEqr0003ConditionVO cvo, EqrScnrEccVO[] vos , SignOnUserAccount account ) throws EventException {
		
	    try {
	    	String user_id = account.getUsr_id();
	    	String tpszType = cvo.getTpsztype();
			String[] tpszArr= tpszType.split(",");											
			
			int rowCount = (vos==null) ? 0 : vos.length;                            
            
            List<String> volList 	 	= null;
            List<String> amtList 	 	= null;
        	List<String> vol_flagList	= null;
        	List<String> amt_flagList	= null;

        	String[] volArr  	= null;
			String[] amtArr  	= null;
        	String[] vol_flagArr= null;
        	String[] amt_flagArr= null;

			//int vol          	= 0;    // type size별 vol 수량
        	double amt          	= 0;    // type size별 amt
        	//String vol_flag  	= "";
        	String amt_flag  	= "";
        	
            for(int k=0; k<rowCount; k++) {
            	EqrScnrEccVO vo = vos[k];
            	//vol     = 0; 
            	volArr  = null;
            	volList = new ArrayList<String>();
            	
            	vol_flagArr  = null;
            	vol_flagList = new ArrayList<String>(); 
            	///vol_flag     = "";          
            	
            	amt     = 0; 
            	amtArr  = null;
            	amtList = new ArrayList<String>();
            	
            	amt_flagArr  = null;
            	amt_flagList = new ArrayList<String>(); 
            	amt_flag     = "";            	            	
            					       	          	    	           	    		
                if(vo.getIbflag().equals("U")) {

				    for(int m=0; m<tpszArr.length; m++) { 				    	
				    	// vol 정보
				    	volArr = (String[])cvo.getVolTpszArr().get(m); 
				    	volList.add(volArr[k]);  // 현재 row에 해당하는 것만 List에 담기
				    	//vol    = Integer.parseInt((String)volList.get(m));	
            	    	
				       	// amt flag 정보 (T, F)
				    	vol_flagArr = (String[])cvo.getVolFlagTpszArr().get(m);
				    	vol_flagList.add(vol_flagArr[k]);           // 현재 row에 해당하는 것만 List에 담기
				    	//vol_flag  = (String)vol_flagList.get(m);	// flag
				       	
				    	// amt 정보
				    	amtArr = (String[])cvo.getAmtTpszArr().get(m);
				    	amtList.add(amtArr[k]);  // 현재 row에 해당하는 것만 List에 담기
				       	amt    = Double.parseDouble((String)amtList.get(m));	
				       					       
            	    	
				       	// amt flag 정보 (T, F)
				       	amt_flagArr = (String[])cvo.getAmtFlagTpszArr().get(m);
				       	amt_flagList.add(amt_flagArr[k]);           // 현재 row에 해당하는 것만 List에 담기
				       	amt_flag  = (String)amt_flagList.get(m);	// flag
				       	
						
						if(amt_flag.equals("T")) {
							// -------------- LINK Info -----------------------------------------
				       		if(vo.getTypeCode().equals("1")) {        				       		
			       				if(tpszArr[m].substring(1,2).equals("2")) {       // TZ_20FT_COST_AMT
			       					EqrScnrEccLnkVO eqrScnrEccLnkVO = new EqrScnrEccLnkVO();
			       					eqrScnrEccLnkVO.setTz20ftCostAmt(amt+"");
			       					eqrScnrEccLnkVO.setUpdUsrId(user_id);
			       					eqrScnrEccLnkVO.setScnrId(vo.getScnrId());
			       					eqrScnrEccLnkVO.setFmEccCd(vo.getFromEcc());
			       					eqrScnrEccLnkVO.setToEccCd(vo.getToEcc());
			       					eqrScnrEccLnkVO.setTrspModCd(vo.getItemCode());			       					
			       			        dbDao.modifyInputDataRLAList20(eqrScnrEccLnkVO);
			       			        
            	    			        
			       				}else if(tpszArr[m].substring(1,2).equals("4")) { // TZ_40FT_COST_AMT
			       					EqrScnrEccLnkVO eqrScnrEccLnkVO = new EqrScnrEccLnkVO();
			       					eqrScnrEccLnkVO.setTz40ftCostAmt(amt+"");
			       					eqrScnrEccLnkVO.setUpdUsrId(user_id);
			       					eqrScnrEccLnkVO.setScnrId(vo.getScnrId());
			       					eqrScnrEccLnkVO.setFmEccCd(vo.getFromEcc());
			       					eqrScnrEccLnkVO.setToEccCd(vo.getToEcc());
			       					eqrScnrEccLnkVO.setTrspModCd(vo.getItemCode());	
			       			        dbDao.modifyInputDataRLAList40(eqrScnrEccLnkVO);
            	    			        				       					
			       				}else {                                           // TZ_45FT_COST_AMT
			       					EqrScnrEccLnkVO eqrScnrEccLnkVO = new EqrScnrEccLnkVO();
			       					eqrScnrEccLnkVO.setTz45ftCostAmt(amt+"");
			       					eqrScnrEccLnkVO.setUpdUsrId(user_id);
			       					eqrScnrEccLnkVO.setScnrId(vo.getScnrId());
			       					eqrScnrEccLnkVO.setFmEccCd(vo.getFromEcc());
			       					eqrScnrEccLnkVO.setToEccCd(vo.getToEcc());
			       					eqrScnrEccLnkVO.setTrspModCd(vo.getItemCode());	
			       			        dbDao.modifyInputDataRLAList45(eqrScnrEccLnkVO);
			       					
			       				}				       			
                            // -------------- ECC Info -----------------------------------------		
				       		}else if(vo.getTypeCode().equals("2")) {  
				       			// 'STD', 'STR', 'HND', 'SHT'
				       			//'STD' --> STV_20FT_COST_AMT, STV_40FT_COST_AMT, STV_45FT_COST_AMT
				                //'STR' --> STO_20FT_COST_AMT, STO_40FT_COST_AMT, STO_45FT_COST_AMT
				                //'HND' --> HNDL_20FT_COST_AMT,HNDL_40FT_COST_AMT,HNDL_45FT_COST_AMT
				                //'SHT' --> STTL_20FT_COST_AMT,STTL_40FT_COST_AMT,STTL_45FT_COST_AMT 				       			
				       			if(vo.getItemCode().equals("STD")) {   
				       				if(tpszArr[m].substring(1,2).equals("2")) {         // STV_20FT_COST_AMT
				       					vo.setStv20ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListStd20(vo);
                	    			        
				       				}else if(tpszArr[m].substring(1,2).equals("4")) {  // STV_40FT_COST_AMT
				       					vo.setStv40ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListStd40(vo);
                	    			        				       					
				       				}else {                                             // STV_45FT_COST_AMT
				       					vo.setStv40ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListStd45(vo);
				       					
				       				}
				       			}else if(vo.getItemCode().equals("STR")) {  
				       				if(tpszArr[m].substring(1,2).equals("2")) {			// STO_20FT_COST_AMT
				       					vo.setSto20ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListStr20(vo);
				       					
				       				}else if(tpszArr[m].substring(1,2).equals("4")) {   // STO_40FT_COST_AMT
				       					vo.setSto40ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListStr40(vo);
				       					
				       				}else {                                             // STO_45FT_COST_AMT
				       					vo.setSto45ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListStr45(vo);
				       				}				       				
				       			}else if(vo.getItemCode().equals("HND")) { 					
				       				if(tpszArr[m].substring(1,2).equals("2")) { // HNDL_20FT_COST_AMT
				       					vo.setHndl20ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListHnd20(vo);
				       					
				       				}else if(tpszArr[m].substring(1,2).equals("4")) {   //  HNDL_40FT_COST_AMT
				       					vo.setHndl40ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListHnd40(vo);
				       					
				       				}else {                                     // HNDL_45FT_COST_AMT
				       					vo.setHndl45ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListHnd45(vo);
				       					
				       				}				       				
				       				
				       			}else if(vo.getItemCode().equals("SHT")) { 
				       				if(tpszArr[m].substring(1,2).equals("2")) { // STTL_20FT_COST_AMT 
				       					vo.setSttl20ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListSht20(vo);
				       									       					
				       				}else if(tpszArr[m].substring(1,2).equals("4")) { 	//  STTL_40FT_COST_AMT 
				       					vo.setSttl40ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListSht40(vo);
				       					
				       				}else { 									// STTL_45FT_COST_AMT 
				       					vo.setSttl45ftCostAmt(amt+"");
				       					vo.setUpdUsrId(user_id);
				       					vo.setEccCd(vo.getFromEcc());
				       			        dbDao.modifyInputDataRLAListSht45(vo);
				       					
				       				}			
				       			}
				       		}				       		
				       	}	
				    } 
                }
            }         
	    } catch (Exception de) {
	        log.error("err "+de.toString(),de);
	        throw new EventException(de.getMessage());
	    }
	}
	    
	
	/**
	 * EQR 업무 시나리오 마감작업<br>
	 * InputDataRlaExamine업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}