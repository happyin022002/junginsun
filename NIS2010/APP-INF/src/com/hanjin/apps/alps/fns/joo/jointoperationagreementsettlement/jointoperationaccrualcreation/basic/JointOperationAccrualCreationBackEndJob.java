/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCreationBackEndJob.java
*@FileTitle : 공동운항추정 산출 BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.11.20 박희동
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2011.06.30 이준범[CHM-201111621-01]
* 제목 : Esitmate Perfomance Creation 화면의 항목 추가 요청
* 내용 : Adjust, Adjusted BSA, Adjusted Slot Cost, Adjuest Estimated Cost, Adjuest Actual Cost, Remark 항목 추가
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration.JointOperationAccrualCreationDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-JointOperationAccrualCreation Long Transaction Business Logic <br>
 * - ALPS-JointOperationAccrualCreation에 대한 Long Transaction 비지니스 로직<br>
 *
 * @author Park Hee Dong
 * @see fns_joo_0029EventResponse 참조
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
	
	        if ("CREATE_RETRIEVE".equals(jobFlg)){
	        	list = dbDao.calJointOperationAccrual(settlementConditionVO);//this.createJointOperationAccrual();
	        }else if ("CREATE".equals(jobFlg)){
	        	this.createJointOperationAccrual();	        	
	        }else if ("SAVE".equals(jobFlg)){
	        	this.manageJointOperationAccrual();
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
	 * Estimation CREATE
	 * @throws Exception
	 */
	private void createJointOperationAccrual() throws Exception {
		
        try {
        	String exeYrmon = settlementConditionVO.getExeYrmon();
        	
        	
        	
        	//1, 대상 조회 후 JOO_ESTM_ACT_RSLT 저장(Target 대상을 exeYrmon에 999912으로 저장)
        	settlementConditionVO.setExeYrmon("999912");        	
        	dbDao.removeJointOperationAccrual (settlementConditionVO);
        	settlementConditionVO.setExeYrmon(exeYrmon);        	
        	dbDao.createJointOperationAccrual(settlementConditionVO);
        	
        	        	
     		//2,  JOO_ESTM_ACT_RSLT 삭제	(추정년월 삭제)        	
        	dbDao.removeJointOperationAccrual (settlementConditionVO);
        	        	
     		//3,  JOO_ESTM_ACT_RSLT 수정	(exeYrmon(999912)를 exeYrmon(추정년월)로 저장)         	
        	settlementConditionVO.setExeYrmon(exeYrmon);
        	dbDao.modifyJointOperationAccrual (settlementConditionVO);        	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Save"}).getMessage(), ex);
        }		
	}	
	
	
	
	
	/**
	 * Estimation Creation create
	 * @param SettlementConditionVO settlementConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws Exception
	 */
//	private List<EstmActRsltVO> createJointOperationAccrual() throws Exception {
//
//        List<EstmActRsltVO> list = null;
//        try {
//        	list = dbDao.calJointOperationAccrual(settlementConditionVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Create"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Create"}).getMessage(), ex);
//        }
//		
//		return list;
//	}
	
	/**
	 * Estimation Save
	 * @throws Exception
	 */
	private void manageJointOperationAccrual() throws Exception {

        List<EstmActRsltVO> updateVoList = new ArrayList<EstmActRsltVO>();
        try {
        	//Create후에 저장한 것이면 삭제 후 insert하고 수정된 것만 update한다.
        	//Retrieve후에 저장하는 것은 Update만 한다.
//            if ("Y".equals(settlementConditionVO.getCreFlg())){
//        		settlementConditionVO.setUsrId(signOnUserAccount.getUsr_id());
//            	List<EstmActRsltVO> list = dbDao.calJointOperationAccrual(settlementConditionVO);
//            	dbDao.removeJointOperationAccrual (settlementConditionVO);
//            	
//            	for ( int i=0; i<list.size(); i++ ) {
//            		list.get(i).setCreUsrId(signOnUserAccount.getUsr_id());
//            	}
//            	
//            	dbDao.addJointOperationAccrualS(list);                        
////                for ( int i=0; i<list.size(); i++ ) {
////                	list.get(i).setCreUsrId(signOnUserAccount.getUsr_id());
////                	dbDao.addJointOperationAccrual(list.get(i));
////                }
//            }
            
            if (estmActRsltVOs != null){
	            for ( int i=0; i<estmActRsltVOs .length; i++ ) {
	            	estmActRsltVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
	                updateVoList.add(estmActRsltVOs[i]);
	            }
            }
            if ( updateVoList.size() > 0 ) {
                dbDao.modifyJointOperationAccruals(updateVoList);
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
	 * ERP로 SEND
	 * @throws EventException
	 */
    private void sendJointOperationAccrualERP() throws EventException{
        try {
/*        	
            String lsYearMn = settlementConditionVO.getExeYrmon().replace("-", "");//estmActRsltVOs[0].getExeYrmon();
            //전체를 보내야 하므로...
            settlementConditionVO.setPageNo("");
            List<EstmActRsltVO> list = dbDao.searchJointOperationAccrualList(settlementConditionVO);            
            //우선 삭제
            dbDao.removeJOOAccural(lsYearMn );

            for (int i=0; i<list.size(); i++){
            	list.get(i).setCreUsrId(signOnUserAccount.getUsr_id());
            	dbDao.addJOOAccurals(list.get(i));
            }
*/            
            
            String lsYearMn = settlementConditionVO.getExeYrmon().replace("-", "");//estmActRsltVOs[0].getExeYrmon();
            //우선 삭제
            dbDao.removeJOOAccural(lsYearMn);
            
            List<EstmActRsltVO> list = dbDao.searchEstmCntList(settlementConditionVO);            
            
            String exeYrmon = "";
            String revYrmon = "";
            String acctCd = "";
            String estmCnt = "";
            EstmActRsltVO estmActRsltVO = new EstmActRsltVO();
            
            for(int i=0; i<list.size(); i++){
            	
            	exeYrmon = list.get(i).getExeYrmon();
            	revYrmon = list.get(i).getRevYrmon();
            	acctCd = list.get(i).getAcctCd();
            	estmCnt = list.get(i).getAcctCd();
            	
            	estmActRsltVO.setExeYrmon(exeYrmon);
            	estmActRsltVO.setRevYrmon(revYrmon);
            	estmActRsltVO.setAcctCd(acctCd);
            	estmActRsltVO.setEstmCnt(estmCnt);            	            	
            	estmActRsltVO.setCreUsrId(signOnUserAccount.getUsr_id());
            	            	
            	dbDao.addJOOAccurals(estmActRsltVO);            	            	            	
            }                        
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
