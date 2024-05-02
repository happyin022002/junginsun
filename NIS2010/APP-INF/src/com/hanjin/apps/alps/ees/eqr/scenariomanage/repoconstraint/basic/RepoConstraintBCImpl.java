/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoConstraintBCImpl.java
*@FileTitle : Constraint by Lane/ECC
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Se-Hoon Park		2006-11-03		1.0 최초 생성
* 2		1.0      	Lee Byoung Hun	2009.08.12		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.12
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration.RepoConstraintDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.vo.EesEqr0138ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrPortDchgCnstVO;
import com.hanjin.syscommon.common.table.EqrScnrRepoCnstVO;

/**
 * ALPS-RepoConstraint Business Logic Basic Command implementation<br>
 * - ALPS-RepoConstraint에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EES_EQR_0138EventResponse,RepoConstraintBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RepoConstraintBCImpl extends BasicCommandSupport implements RepoConstraintBC {

	// Database Access Object
	private transient RepoConstraintDBDAO dbDao = null;

	/**
	 * RepoConstraintBCImpl 객체 생성<br>
	 * RepoConstraintDBDAO를 생성한다.<br>
	 */
	public RepoConstraintBCImpl() {
		dbDao = new RepoConstraintDBDAO();
	}
	
	/**
	 * Constraint by Lane/ECC 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0138ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchConstraintLaneEccInfo(EesEqr0138ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchConstraintLaneEccInfo(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Constraint by Lane/ECC 멀티 이벤트 처리<br>
	 * 
	 * @param eqrScnrPortDchgCnstVOS EqrScnrPortDchgCnstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyConstraintLaneEccInfo(EqrScnrPortDchgCnstVO[] eqrScnrPortDchgCnstVOS, SignOnUserAccount account) throws EventException {
		try {
			List<EqrScnrPortDchgCnstVO> updateVoList = new ArrayList<EqrScnrPortDchgCnstVO>();
			List<EqrScnrPortDchgCnstVO> deleteVoList = new ArrayList<EqrScnrPortDchgCnstVO>();
			
			for ( int i=0; i<eqrScnrPortDchgCnstVOS .length; i++ ) {
				if (eqrScnrPortDchgCnstVOS[i].getIbflag().equals("I") || eqrScnrPortDchgCnstVOS[i].getIbflag().equals("U")){
					eqrScnrPortDchgCnstVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrScnrPortDchgCnstVOS[i]);
					
				} else if (eqrScnrPortDchgCnstVOS[i].getIbflag().equals("D")) {
					deleteVoList.add(eqrScnrPortDchgCnstVOS[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyConstraintLaneEccInfo(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteConstraintLaneEccInfo(deleteVoList);
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
     * EES_EQR_022 에 대한 추가 이벤트 처리<br>
     * 
     * @param scnrid
     * @param cnsttype
     * @param tpsz
     * @return CommonRsVO
     * @exception EventException
   */
    public CommonRsVO searchEmptyRepoConstraintInfo(String scnrid ,String cnsttype , String tpsz) throws EventException {
        CommonRsVO commonRsVO = null;        
        try {	

    		List<String> tpszArr = Utils.replaceStrToList(tpsz);//tpsz.split(",");
        	commonRsVO = dbDao.searchEmptyRepoConstraintInfo(scnrid , cnsttype , tpszArr);
      	
            return commonRsVO;
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	   

    /**
     * 등록/수정 이벤트 처리<br>
     * EES_EQR_022 에 대한 추가 이벤트 처리<br>
     * 
     * @param String scnr_id
     * @param String cnsttype
     * @param String tpsz
     * @param EqrScnrRepoCnstVO[] vos
     * @param SignOnUserAccount account
     * @return CommonRsVO
     * @exception EventException
   */
	public CommonRsVO modifyEmptyRepoConstraintInfo(String scnr_id, String cnsttype, String tpsz, EqrScnrRepoCnstVO[] vos, SignOnUserAccount account) throws EventException {
        
    	int cnstSeq		= 0;
        int ruleSeq 	= 0;
        String ruleCode = "";
        String ruleCodeTemp = "";
        String nationCode = "";
        //String eccType = "";
        String eccCode = "";
        boolean isInsert = false;
        boolean isUpdate = false;
        boolean isDelete = false;
    	CommonRsVO commonRsVO = null;
        
        try {	
        	
        	List<Map<String, Object>> insModels = new ArrayList<Map<String, Object>>();
        	List<Map<String, Object>> updModels = new ArrayList<Map<String, Object>>();
        	List<Map<String, Object>> delModels = new ArrayList<Map<String, Object>>();
        	String user_id = account.getUsr_id();
        	
        	for(int i = 0 ; i < vos.length ; i++){
        		EqrScnrRepoCnstVO vo = vos[i];
        		if(vo.getIbflag().length() > 0){
        			if("".equals(vo.getFmLocGrpCd())){
        				vo.setFmLocGrpCd("N");
                    }
                    if("".equals(vo.getFmLocCd())){
                    	vo.setFmLocCd("N/A");
                    }	                    		
                    if("".equals(vo.getToLocGrpCd())){
                    	vo.setToLocGrpCd("N");
                    }
                    if("".equals(vo.getToLocCd())){
                    	vo.setToLocCd("N/A");
                    }	  
                    if("1".equals(vo.getRuleExptFlg())){
                    	vo.setRuleExptFlg("Y");
                    }
                    if("0".equals(vo.getRuleExptFlg())){
                    	vo.setRuleExptFlg("N");
                    }
                    
                    if (vo.getIbflag().equals("I")) {
                    	// rule code 생성
                    	if("".equals(vo.getCnstRuleId())){ // 기본입력(exception이 아닌경우)
                    		
	                    	if("H".equals(vo.getRepoCnstTpCd()) ){
	                    		//modified : N200801250015 :  Direction 방식이 FM -> TO pair 개념으로 변경
	                    		//FM/TO  다 넣으므로 FM 기준으로 ruleCode 생성.
//	                    		if("FM".equals(model.getRepo_cnst_dir_cd())){
	                    		/* modified : N200803040009  : Constraint 화면 HJS Rule 관련 Fm/To/Mode에 'All' 조건 추가 
          						 - loc_grp_cd 가 'All'일 경우 loc_cd가 입력되지 않으므로 입력된 loc_cd 를 기준으로 rule_id를 생성한다.
          						 -           (ex. Fm_loc_grp_cd= 'A' 이면 rule는 To_loc_cd의 값으로 생성)
	                    		 */	 
	                    		if("A".equals(vo.getFmLocGrpCd())){
	                    			eccCode = vo.getToLocCd();
	                    			//eccType = vo.getToLocGrpCd();
	                    		} else if("A".equals(vo.getToLocGrpCd())){	
	                    			eccCode = vo.getFmLocCd();
	                    			//eccType = vo.getFmLocGrpCd();
	                    		}else {
	                    			eccCode = vo.getFmLocCd();
	                    			//eccType = vo.getFmLocGrpCd();
	                    		}		                    			
//	                    		}else if("TO".equals(model.getRepo_cnst_dir_cd())){
//	                    			eccCode = model.getTo_loc_cd();
//	                    			eccType = model.getTo_loc_grp_cd();
//	                    		}
	                    	}else if("C".equals(vo.getRepoCnstTpCd()) ){
	                    		eccCode = vo.getFmLocCd();
	                    		//eccType = "C";
	                    	}
	                    	// 국가 코드 생성
	                    	nationCode = eccCode.substring(0,2);
	                    	
	                    	if(0==ruleSeq){
	                    		ruleSeq = dbDao.createCnstRuleId(nationCode, vo.getRepoCnstTpCd(), scnr_id);
	                    		
	                    	}else {
	                    		ruleSeq++;
	                    	}
	                    	ruleCodeTemp = "000" + ruleSeq;
	                    	ruleCode = nationCode + ruleCodeTemp.substring(ruleCodeTemp.length()-4,ruleCodeTemp.length()) + vo.getRepoCnstTpCd();
                    	
                    	}else{
                    		ruleCode = vo.getCnstRuleId();
                    	}
                    	// seq 생성
                    	if(0==cnstSeq){
                    		cnstSeq = dbDao.createCnstSeq();
                    	}else{
                    		cnstSeq++;
                    	}
                    	
                    	StringTokenizer tokens = new StringTokenizer( vo.getCnstCntrTpszCd(), "|" );
                    	for( int c = 1; tokens.hasMoreElements(); c++ ){
	                        isInsert = true;
	                		//query parameter
	                		Map<String, Object> param = new HashMap<String, Object>();
	                		param.putAll(vo.getColumnValues());
	                		param.put("ruleCode", ruleCode);
	                		param.put("tokens", tokens.nextToken()+"");
	                		param.put("cnstSeq", cnstSeq+"");
	                        //modified : N200801250015 :  Direction 방식이 FM -> TO pair 개념으로 변경
	                	    // FM/To 가 아니므로 'H'의 경우 모두 'ALL'로 셋팅
	                        if("H".equals(vo.getRepoCnstTpCd()) ){
	                        	param.put("repo_cnst_dir_cd", "AL");
	                        }
	                        else {
	                        	param.put("repo_cnst_dir_cd", vo.getRepoCnstDirCd());
	                        } 	
	                        param.put("user_id", user_id);
	                        insModels.add(param);
                		}
                    } else if (vo.getIbflag().equals("U")) {
                        isDelete = true ;
                        Map<String, Object> delparam = new HashMap<String, Object>();
                        delparam.put("repo_cnst_seq", vo.getRepoCnstSeq());
                        delparam.put("scnr_id", vo.getScnrId());
                        delModels.add(delparam);
                        
                    	StringTokenizer tokens = new StringTokenizer( vo.getCnstCntrTpszCd(), "|" );
                		for( int cc = 1; tokens.hasMoreElements(); cc++ ){
                    		isUpdate = true ;
	                		//query parameter
	                		Map<String, Object> param = new HashMap<String, Object>();
	                		param.putAll(vo.getColumnValues());
	                		param.put("tokens",tokens.nextToken());
                        	//modified : N200801250015 :  Direction 방식이 FM -> TO pair 개념으로 변경
	                	    // FM/To 가 아니므로 'H'의 경우 모두 'ALL'로 셋팅
	                        //if("H".equals(model.getRepo_cnst_dir_cd()) ){
	                    	//기존에 FM/TO 방식으로 저장된 데이터의 경우 기존의 값을 입력.
	                    	if("".equals(vo.getRepoCnstDirCd()) ){
	                        	param.put("repo_cnst_dir_cd","AL");
	                        }
	                        else {
		                		param.put("repo_cnst_dir_cd",vo.getRepoCnstDirCd());
	                        }	
	                    	param.put("user_id", user_id);
	                    	updModels.add(param);
                	        
                		}
                    } else if (vo.getIbflag().equals("D")) {
                        isDelete = true ;
                		//query parameter
                		Map<String, Object> param = new HashMap<String, Object>();
                		param.put("repo_cnst_seq", vo.getRepoCnstSeq());
                		param.put("scnr_id", vo.getScnrId());
                        delModels.add(param);
                    }                    
        		}
        	}
           
			
			// INSERT, UPDATE, DELETE 를 DB에 적용
        	if(isDelete){
        		dbDao.deleteEmptyRepoConstraintInfo(delModels);
			}
        	if(isInsert){
        		dbDao.insertEmptyRepoConstraintInfo(insModels);
			}
        	if(isUpdate){
        		dbDao.modifyEmptyRepoConstraintInfo(updModels);
			}
        	
        	
        	List<String> tpszArr = Utils.replaceStrToList(tpsz);//tpsz.split(",");
        	// Select 수행
        	commonRsVO = dbDao.searchEmptyRepoConstraintInfo(scnr_id , cnsttype , tpszArr);

        	return commonRsVO;
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	
}