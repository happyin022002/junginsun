/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCreationBackEndJob.java
*@FileTitle : Joint Operation Agreement Creation BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration.JointOperationAccrualCreationDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-JointOperationAccrualCreation Long Transaction Business Logic <br>
 *
 * @author
 * @see fns_joo_0029EventResponse
 * @since J2EE 1.6
 */
public class JointOperationAccrualCreationBackEndJob extends BackEndCommandSupport {
	
	private JointOperationAccrualCreationDBDAO dbDao;
	private EstmActRsltVO[] estmActRsltVOs = null;
	private SettlementConditionVO settlementConditionVO = null;
	private SignOnUserAccount signOnUserAccount = null;
	private String jobFlg = null;	

	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = -4432166936180768897L;

	/**
	 * Main Start
	 * @return List<EstmActRsltVO>
	 * @throws Exception
	 */
	public List<EstmActRsltVO> doStart() throws Exception {
        List<EstmActRsltVO> list = null;
        try{
	        dbDao = new JointOperationAccrualCreationDBDAO();
	
	        if ("CREATE".equals(jobFlg)){
	        	//list = dbDao.calJointOperationAccrual(settlementConditionVO);//
	        	list = this.createJointOperationAccrual();
	        }else if ("SAVE".equals(jobFlg)){
	        	this.manageJointOperationAccrual();
	        	this.sendJointOperationAccrualERP();
	        	//list = dbDao.searchJointOperationAccrualList(settlementConditionVO);
	        }else if ("SEND".equals(jobFlg)){
	        	this.sendJointOperationAccrualERP();
	        	//list = dbDao.searchJointOperationAccrualList(settlementConditionVO);
	        }
        }catch(Exception e){
        	super.log.error(e.getMessage());
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", ""}).getMessage(), e);
        }
        
        return list;
	}

	/**
	 * JOB FLAG setting
	 * @param String jobFlg
	 */
	public void setJobFlg(String jobFlg){
		this.jobFlg = jobFlg;
	}

	/**
	 * Estimation Creation create
	 * @param SettlementConditionVO settlementConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws Exception
	 */
	private List<EstmActRsltVO> createJointOperationAccrual() throws Exception {

        List<EstmActRsltVO> list = null;
        try {
        	//2015.03.05 NYK Modify
        	//1.조건에 맞추어서 Create 로직을 태운다.(Default 로 By Month 기준으로 데이타를 생성한다.)
        	//Accrual Month, Rev/Exp, Trade, Lane, Partner, Item, VVD
    		settlementConditionVO.setUsrId(signOnUserAccount.getUsr_id());
    		settlementConditionVO.setOfcCd(signOnUserAccount.getOfc_cd());
    		
    		log.debug("\ncreateJointOperationAccrual calJointOperationAccrual Call.");
        	list = dbDao.calJointOperationAccrual(settlementConditionVO);
        	
        	if(null != list && list.size() > 0 ){
	        	SettlementConditionVO condVo = new SettlementConditionVO();
	        	condVo.setExeYrmon(settlementConditionVO.getExeYrmon()); //Accrual Month
	        	condVo.setReDivrCd(settlementConditionVO.getReDivrCd()); //Rev/Exp
	        	condVo.setTrdCd(settlementConditionVO.getTrdCd());		 //Trade
	        	condVo.setRlaneCd(settlementConditionVO.getRlaneCd());	 //Lane
	        	condVo.setJoCrrCd(settlementConditionVO.getJoCrrCd());	 //Carrier(Partner)
	        	condVo.setJoStlItmCd(settlementConditionVO.getJoStlItmCd());	 //Item ex) S/H,OPR String으로 넘어옴.
	        	condVo.setVvd(settlementConditionVO.getVvd());	 //VVD
	        	condVo.setCreFlg(JooConstants.KEY_CRE_FLG_BACKEND);
	        	condVo.setPageNo("");
	        	
	        	//2.조건에 맞추어 JOO_ESTM_ACT_RSLT 테이블 Delete 한다.(기존에 등록된 Data 삭제 : exe_yrmon, rlane_cd 조건)
	        	//Accrual Month, Rev/Exp, Trade, Lane, Partner, Item, VVD
	        	log.debug("\ncreateJointOperationAccrual removeJointOperationAccrual Call.");
	        	dbDao.removeJointOperationAccrual (condVo);
	        	
	        	log.debug("\ncreateJointOperationAccrual addJointOperationAccrualList Insert Size ["+list.size()+"] Call.");
	        	//3.JOO_ESTM_ACT_RSLT 1번으로 Insert.
	        	dbDao.addJointOperationAccrualList(list);
	        	/*int iCnt = 1;
	        	for(EstmActRsltVO vo : list){
	        		log.debug("\ncreateJointOperationAccrual addJointOperationAccrualList Processing Cnt["+iCnt+"].");
		        	dbDao.addJointOperationAccrualS(vo);		        	
		        	iCnt++;
	        	}*/       	
	        	log.debug("\ncreateJointOperationAccrual addJointOperationAccrualList End.");
	        	
	        	//4.voy_days_cd : By Month(M) 이면 그대로 화면으로 Return, By VVD(V) 이면 Create후에 Insert 한 데이타를 재조회한다.
	        	//if(JooConstants.KEY_VOY_DAYS_CD_VVD.equals(settlementConditionVO.getVoyDaysCd())){
	        	//	list = dbDao.searchJointOperationAccrualByVvdList(condVo);  
	        	//}
	        	
        	}
        	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Create"}).getMessage(), ex);
        }
		
		return list;
	}
	
	/**
	 * Estimation Save
	 * @throws Exception
	 */
	private void manageJointOperationAccrual() throws Exception {

        List<EstmActRsltVO> deleteVoList = new ArrayList<EstmActRsltVO>();
        List<EstmActRsltVO> insertVoList = new ArrayList<EstmActRsltVO>();
        List<EstmActRsltVO> updateVoList = new ArrayList<EstmActRsltVO>();
        try {
        	
        	if(null != estmActRsltVOs && estmActRsltVOs.length > 0){
        		for(int i=0; i < estmActRsltVOs.length ; i++){
        			estmActRsltVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
        			estmActRsltVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
        			if("D".equals(estmActRsltVOs[i].getIbflag())){
        				//1.Delete
        				deleteVoList.add(estmActRsltVOs[i]);
        			}else if("U".equals(estmActRsltVOs[i].getIbflag())){
        				//2.Update
        				updateVoList.add(estmActRsltVOs[i]);
        			}else if("I".equals(estmActRsltVOs[i].getIbflag()) && StringUtils.isEmpty(estmActRsltVOs[i].getEstmActSeq())){
        				//3.Insert
        				insertVoList.add(estmActRsltVOs[i]);
        			}
        		}
        	}
        	
        	
        	if(null != deleteVoList && deleteVoList.size() > 0){
        		log.debug("\nmanageJointOperationAccrual Delete Size["+deleteVoList.size()+"]");
        		dbDao.removeJointOperationAccrualList (deleteVoList);
        	}
        	
        	if(null != updateVoList && updateVoList.size() > 0){
        		log.debug("\nmanageJointOperationAccrual Update Size["+updateVoList.size()+"]");
        		dbDao.modifyJointOperationAccruals(updateVoList);
        	}
        	
        	if(null != insertVoList && insertVoList.size() > 0){
        		log.debug("\nmanageJointOperationAccrual Insert Size["+insertVoList.size()+"]");
        		for(int i=0; i < insertVoList.size(); i++){
        			EstmActRsltVO estmActRsltVO = insertVoList.get(i);
        			
        			String maxEstmActSeq = dbDao.searchMaxEstmActSeq(estmActRsltVO);
        			log.debug("\nnmanageJointOperationAccrual Insert maxEstmActSeq["+maxEstmActSeq+"]");
        			estmActRsltVO.setEstmActSeq(maxEstmActSeq);  
        			
        			dbDao.addJointOperationAccrual(estmActRsltVO);
        		}
        		
        		//dbDao.addJointOperationAccrualList(insertVoList); 
        	}
        	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Save"}).getMessage(), ex);
        }		
	}
	
	/**
	 * sending ERP
	 * @throws EventException
	 */
    private void sendJointOperationAccrualERP() throws EventException{
        try {
            String lsYearMn = settlementConditionVO.getExeYrmon().replace("-", "");//estmActRsltVOs[0].getExeYrmon();
            
            settlementConditionVO.setPageNo("");
            settlementConditionVO.setUsrId(signOnUserAccount.getUsr_id());
            //List<EstmActRsltVO> list = dbDao.searchJointOperationAccrualList(settlementConditionVO);            
            
            dbDao.removeJOOAccural(lsYearMn );

            dbDao.addJOOAllAccurals(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimate", "I/F"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimate", "I/F"}).getMessage(), ex);
        }
    }
	

	/**
	 * EstmActRsltVO[] setting
	 * @param EstmActRsltVO[] estmActRsltVOs
	 */
	public void setEstmActRsltVOs(EstmActRsltVO[] estmActRsltVOs) {
		if (estmActRsltVOs != null) {
			EstmActRsltVO[] tmpVOs = new EstmActRsltVO[estmActRsltVOs.length];
			System.arraycopy(estmActRsltVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.estmActRsltVOs = tmpVOs;
		}
	}

	/**
	 * SettlementConditionVO setting
	 * @param SettlementConditionVO settlementConditionVO
	 */
	public void setSettlementConditionVO(SettlementConditionVO settlementConditionVO) {
		this.settlementConditionVO = settlementConditionVO;
	}

	/**
	 * SignOnUserAccount setting
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setSignOnUserAccount(SignOnUserAccount signOnUserAccount) {
		this.signOnUserAccount = signOnUserAccount;
	}
}
