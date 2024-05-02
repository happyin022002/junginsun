/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RenewalConsultationBackEndJob.java
*@FileTitle : RenewalConsultation BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration.RenewalConsultationDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.SettlementTargetVO;
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
public class RenewalConsultationBackEndJob extends BackEndCommandSupport {
	
	private RenewalConsultationDBDAO dbDao;
	private SettlementTargetVO[] settlementTargetVOS = null;
	private SettlementTargetVO settlementTargetVO = null;
	private SignOnUserAccount signOnUserAccount = null;
	private String jobFlg = null;	

	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = -4432166936180768897L;

	/**
	 * Main Start
	 * @return List<SettlementTargetVO>
	 * @throws Exception
	 */
	public List<SettlementTargetVO> doStart() throws Exception {
        List<SettlementTargetVO> list = null;
        try{
	        dbDao = new RenewalConsultationDBDAO();
	
	        if ("RETRIEVE".equals(jobFlg)){
	        	list = this.searchSettlementTargetList();
	        }else if ("CREATE".equals(jobFlg)){
	        	list = this.calculateSettlementTargetList();
	        }else if ("SAVE".equals(jobFlg)){
	        	this.manageSettlementTargetList();
	        }
        }catch(Exception e){
        	super.log.error(e.getMessage());
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select Target VVD for Settlement Back End Job", ""}).getMessage(), e);
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
	 * Retrieve : Select Target VVD For Settlement Creation화면 조회.
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
	 * @return List<SettlementTargetVO>
	 * @throws Exception
	 */
	private List<SettlementTargetVO> searchSettlementTargetList() throws Exception {

        List<SettlementTargetVO> list = null;
        try {
        	settlementTargetVO.setCreUsrId(signOnUserAccount.getUsr_id());
        	list = dbDao.searchSettlementTargetList(settlementTargetVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select Target VVD for Settlement Back End Job", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select Target VVD for Settlement Back End Job", "Retrieve"}).getMessage(), ex);
        }
		
		return list;
	}

	/**
	 * Create : Select Target VVD For Settlement Creation화면 조회.
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
	 * @return List<SettlementTargetVO>
	 * @throws Exception
	 */
	private List<SettlementTargetVO> calculateSettlementTargetList() throws Exception {

        List<SettlementTargetVO> list = null;
        try {
        	settlementTargetVO.setCreUsrId(signOnUserAccount.getUsr_id());
        	list = dbDao.calculateSettlementTargetList(settlementTargetVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select Target VVD for Settlement Back End Job", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select Target VVD for Settlement Back End Job", "Create"}).getMessage(), ex);
        }
		
		return list;
	}
	
	/**
	 * Save : Select Target VVD For Settlement Creation화면 저장.
	 * 
	 * @category FNS_JOO_0101
	 * @throws Exception
	 */
	private void manageSettlementTargetList() throws Exception {
		List<SettlementTargetVO> deleteVoList = new ArrayList<SettlementTargetVO>();
        List<SettlementTargetVO> insertVoList = new ArrayList<SettlementTargetVO>();
        List<SettlementTargetVO> updateVoList = new ArrayList<SettlementTargetVO>();
        try {
        	log.debug("\n manageSettlementTargetList START ======================================");
        	int iLoopCnt = 0;
        	for(SettlementTargetVO vo : settlementTargetVOS){
        		vo.setCreUsrId(signOnUserAccount.getUsr_id());
        		vo.setUpdUsrId(signOnUserAccount.getUsr_id());
        		String tmpStlTgtFlg = StringUtils.isEmpty(vo.getStlTgtFlg()) ? "0" : vo.getStlTgtFlg();
        		tmpStlTgtFlg = tmpStlTgtFlg.equals("0") ? "N" : "Y";
        		String tmpStlVvdSeq = "";
        		
        		log.debug("\n manageSettlementTargetList getIbflag ["+iLoopCnt+"]["+vo.getIbflag()+"]["+tmpStlTgtFlg+"]");
        		
        		if(!"R".equals(vo.getIbflag()) && !StringUtils.isEmpty(vo.getStlVvdSeq())){
        			log.debug("\n manageSettlementTargetList Exist StlVvdSeq Call.");
        			
        			tmpStlVvdSeq = dbDao.searchExistStlVvdSeq(vo);
        			
        			log.debug("\n manageSettlementTargetList Before Vo stlVvdSeq ["+vo.getStlVvdSeq()+"] tmpStlVvdSeq :["+tmpStlVvdSeq+"]");
        			
        			if(!StringUtils.isEmpty(tmpStlVvdSeq)){
        				vo.setStlVvdSeq(tmpStlVvdSeq);
        			}
        			
        			log.debug("\n manageSettlementTargetList After Vo stlVvdSeq ["+vo.getStlVvdSeq()+"]");
        		}
        		
        		
        		if("D".equals(vo.getIbflag())){
        			//STL_VVD_SEQ 가 존재 한 데이타는 JOO_STL_TGT에 존재 한 데이타로 봄.
        			if(!StringUtils.isEmpty(vo.getStlVvdSeq())){
        				deleteVoList.add(vo);
        			}
        		}else if("U".equals(vo.getIbflag())){
        			if(!StringUtils.isEmpty(vo.getStlVvdSeq())){
        				//ACT_AMT 0 보다 크거나, 작으면 입력 값으로 판단하여 새로 Insert 하도록 함.
        				/*double dTmpActMat = Double.parseDouble(vo.getActAmt());
        				if(dTmpActMat != 0){
        					insertVoList.add(vo);
        				}else{*/
        					updateVoList.add(vo);
        				//}
        			}else{
        				insertVoList.add(vo);
        			}
        		}else if("I".equals(vo.getIbflag())){
        			if(!StringUtils.isEmpty(vo.getStlVvdSeq())){
        				updateVoList.add(vo);
        			}else{
        				insertVoList.add(vo);
        			}
        		}
        		
        		iLoopCnt++;
        	}
        	
        	if(null != deleteVoList && deleteVoList.size() > 0){
        		log.debug("\n manageSettlementTargetList Delete Size["+deleteVoList.size()+"]");
        		
        		for(SettlementTargetVO delVo : deleteVoList){
        			//1. 하위 존재 여부 체크.JOO_INVOICE, JOO_INV_DTL
        			InvoiceDetailVO chkDtlVo = new InvoiceDetailVO();
        			chkDtlVo.setVslCd(delVo.getVslCd());
        			chkDtlVo.setSkdVoyNo(delVo.getSkdVoyNo());
        			chkDtlVo.setSkdDirCd(delVo.getSkdDirCd());
        			chkDtlVo.setRevYrmon(delVo.getRevYrmon());
        			chkDtlVo.setStlVvdSeq(delVo.getStlVvdSeq());
        			
        			String chkExistDtlFlg = dbDao.checkExistInvoiceDetail(chkDtlVo);
        			if(chkExistDtlFlg.equals("N")){
        				//2.JOO_STL_TGT Delete.
        				dbDao.removeSettlementTarget(delVo);
        			}
            	}
        	}
        	
        	if(null != updateVoList && updateVoList.size() > 0){
        		log.debug("\n manageSettlementTargetList Update Size["+updateVoList.size()+"]");
        		for(SettlementTargetVO upVo : updateVoList){
        			dbDao.modifySettlementTarget(upVo);
        		}
        	}
        	
        	if(null != insertVoList && insertVoList.size() > 0){
        		log.debug("\n manageSettlementTargetList Insert Size["+insertVoList.size()+"]");
        		for(SettlementTargetVO inVo : insertVoList){
        			String maxStlVvdSeq = dbDao.searchMaxStlVvdSeq(inVo);
        			
        			log.debug("\n manageSettlementTargetList Insert maxStlVvdSeq["+maxStlVvdSeq+"]");
        			
        			inVo.setStlVvdSeq(maxStlVvdSeq);
        			
        			dbDao.addSettlementTarget(inVo);
        		}
        	}
        	
        	log.debug("\n manageSettlementTargetList E N D ======================================");
        	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select Target VVD for Settlement Back End Job", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Select Target VVD for Settlement Back End Job", "Save"}).getMessage(), ex);
        }		
	}

	/**
	 * SettlementTargetVO[] setting
	 * @param SettlementTargetVO[] settlementTargetVOS
	 */
	public void setSettlementTargetVOS(SettlementTargetVO[] settlementTargetVOS) {
		if (settlementTargetVOS != null) {
			SettlementTargetVO[] tmpVOs = new SettlementTargetVO[settlementTargetVOS.length];
			System.arraycopy(settlementTargetVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.settlementTargetVOS = tmpVOs;
		}
	}

	/**
	 * SettlementTargetVO setting
	 * @param SettlementTargetVO settlementTargetVO
	 */
	public void setSettlementTargetVO(SettlementTargetVO settlementTargetVO) {
		this.settlementTargetVO = settlementTargetVO;
	}

	/**
	 * SignOnUserAccount setting
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setSignOnUserAccount(SignOnUserAccount signOnUserAccount) {
		this.signOnUserAccount = signOnUserAccount;
	}
}
