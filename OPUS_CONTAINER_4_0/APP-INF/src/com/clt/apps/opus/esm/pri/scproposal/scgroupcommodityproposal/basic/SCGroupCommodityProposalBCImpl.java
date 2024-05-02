/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityProposalBCImpl.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.integration.SCGroupCommodityProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.GrpCmdtPropVO;
import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - handling biz logic about SCProposal<br>
 *
 * @author  
 * @see ESM_PRI_0003_03EventResponse,SCGroupCommodityProposalBC reference each DAO class
 * @since J2EE 1.6
 */
public class SCGroupCommodityProposalBCImpl extends BasicCommandSupport implements SCGroupCommodityProposalBC {

	// Database Access Object
	private transient SCGroupCommodityProposalDBDAO dbDao = null;

	/**
	 * SCGroupCommodityProposalBCImpl object creation<br>
	 * creating SCGroupCommodityProposalDBDAO<br>
	 */
	public SCGroupCommodityProposalBCImpl() {
		dbDao = new SCGroupCommodityProposalDBDAO();
	}
		
	/**
	 * Commodity Group Detail retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO  
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityDetailList(priSpScpGrpCmdtDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Commodity Group retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtVO priSpScpGrpCmdtVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityList(priSpScpGrpCmdtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * retrieving using data in GRI COMMODITY GROUP & GRP COMMODITY GROUP<br>
	 * can not delete , when data exist<br>
	 * 
	 * @param PriSpScpGrpCmdtVO[]   priSpScpGrpCmdtVOs
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateApplyList(PriSpScpGrpCmdtVO[] priSpScpGrpCmdtVOs) throws EventException {
		try {
			PriSpScpGrpCmdtVO vo = new PriSpScpGrpCmdtVO();
			vo.setPropNo(priSpScpGrpCmdtVOs[0].getPropNo());
			vo.setAmdtSeq(priSpScpGrpCmdtVOs[0].getAmdtSeq());
			vo.setSvcScpCd(priSpScpGrpCmdtVOs[0].getSvcScpCd());
			List<String> txtArr = new ArrayList<String>();
			for(int i=0;i<priSpScpGrpCmdtVOs.length;i++){
				txtArr.add(priSpScpGrpCmdtVOs[i].getGrpCmdtSeq());
			}
			return dbDao.searchGroupCommodityRateApplyList (vo, txtArr);			

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * retrieving using data in COMMODITY GROUP DTL  <br>
	 * can not delete , when data exist<br>
	 * 
	 * @param PriSpScpGrpCmdtVO[]   priSpScpGrpCmdtVOs
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateAcceptedList(PriSpScpGrpCmdtVO[] priSpScpGrpCmdtVOs) throws EventException {
		try {
			PriSpScpGrpCmdtVO vo = new PriSpScpGrpCmdtVO();
			vo.setPropNo(priSpScpGrpCmdtVOs[0].getPropNo());
			vo.setAmdtSeq(priSpScpGrpCmdtVOs[0].getAmdtSeq());
			vo.setSvcScpCd(priSpScpGrpCmdtVOs[0].getSvcScpCd());
			List<String> txtArr = new ArrayList<String>();
			for(int i=0;i<priSpScpGrpCmdtVOs.length;i++){
				txtArr.add(priSpScpGrpCmdtVOs[i].getGrpCmdtSeq());
			}
			return dbDao.searchGroupCommodityRateAcceptedList (vo, txtArr);			

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Guideline Commodity Group Detail Copying<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineGroupCommodity(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO, SignOnUserAccount account) throws EventException{
		try {	
			
			List<PriSpScpGrpCmdtDtlVO> insertVoList = new ArrayList<PriSpScpGrpCmdtDtlVO>();
			priSpScpGrpCmdtDtlVO.setCreUsrId(account.getUsr_id());
			priSpScpGrpCmdtDtlVO.setUpdUsrId(account.getUsr_id());
			insertVoList.add(priSpScpGrpCmdtDtlVO);
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalMainGroupCommodityGlineCopy (insertVoList);
				dbDao.addProposalMainGroupCommodityDetailGlineCopy (insertVoList);			
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Commodity Group saving<br>
	 * 
	 * @param GrpCmdtPropVO grpCmdtPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupCommodity(GrpCmdtPropVO grpCmdtPropVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpScpGrpCmdtVO[] vo = grpCmdtPropVO.getPriSpScpGrpCmdtVOs();
			PriSpScpGrpCmdtDtlVO[] dtlvo = grpCmdtPropVO.getPriSpScpGrpCmdtDtlVOs();
			
			List<PriSpScpGrpCmdtVO> insertVoList = new ArrayList<PriSpScpGrpCmdtVO>();
			List<PriSpScpGrpCmdtVO> updateVoList = new ArrayList<PriSpScpGrpCmdtVO>();
			List<PriSpScpGrpCmdtVO> deleteVoList = new ArrayList<PriSpScpGrpCmdtVO>();
			List<PriSpScpGrpCmdtDtlVO> insertDtlVoList = new ArrayList<PriSpScpGrpCmdtDtlVO>();
			List<PriSpScpGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriSpScpGrpCmdtDtlVO>();
			List<PriSpScpGrpCmdtDtlVO> deleteDtlVoList = new ArrayList<PriSpScpGrpCmdtDtlVO>();			
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());					
					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("D")){
					vo[i].setUpdUsrId(account.getUsr_id());					
					deleteVoList.add(vo[i]);
				}
			}
			
			for ( int i = 0; dtlvo != null && i < dtlvo.length; i++ ) {
				if ( dtlvo[i].getIbflag().equals("I")){
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());					
					insertDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("U")){
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("D")){
					dtlvo[i].setUpdUsrId(account.getUsr_id());					
					deleteDtlVoList.add(dtlvo[i]);
				}
			}			
			if ( insertVoList.size() > 0 ) {
				dbDao.addGroupCommodity(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyGroupCommodity(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeAddedGroupCommodityDtl(deleteVoList);
				dbDao.modifyDeleteGroupCommodityDtl(deleteVoList);					
				dbDao.removeGroupCommodity(deleteVoList);
			}
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.addGroupCommodityDetail(insertDtlVoList);
			}
			
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupCommodityDetail(updateDtlVoList);
			}
			
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeGroupCommodityDetail(deleteDtlVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Commodity Group accepting<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupCommodity(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO, SignOnUserAccount account) throws EventException{
		
		String result = "FAIL";
		
		try {
			priSpScpGrpCmdtDtlVO.setPrcProgStsCd("A");
			priSpScpGrpCmdtDtlVO.setAcptUsrId(account.getUsr_id());
			priSpScpGrpCmdtDtlVO.setAcptOfcCd(account.getOfc_cd());					
			priSpScpGrpCmdtDtlVO.setUpdUsrId(account.getUsr_id());
			int cnt = dbDao.searchGroupCommodityDetailStatusList(priSpScpGrpCmdtDtlVO);

			if(cnt>0){
				dbDao.modifyAllGroupCommodityDetail(priSpScpGrpCmdtDtlVO);	
				result = "OK";
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		
		return result;
	}

	/**
	 * Commodity Group accept canceling<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupCommodity(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO, SignOnUserAccount account) throws EventException{
	
		String result = "";
		
		try {
			priSpScpGrpCmdtDtlVO.setPrcProgStsCd("I");
			priSpScpGrpCmdtDtlVO.setAcptUsrId(account.getUsr_id());
			priSpScpGrpCmdtDtlVO.setAcptOfcCd(account.getOfc_cd());					
			priSpScpGrpCmdtDtlVO.setUpdUsrId(account.getUsr_id());
			int cnt = dbDao.searchGroupCommodityDetailStatusList(priSpScpGrpCmdtDtlVO);

			if(cnt>0){
				dbDao.modifyAllGroupCommodityDetail(priSpScpGrpCmdtDtlVO);	
				result = "OK";
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		
		return result;
	}    

	/**
	 * Commodity Group accepting<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO[] vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGroupCommodity(PriSpScpGrpCmdtDtlVO[] vo, SignOnUserAccount account) throws EventException{
		try {

			List<PriSpScpGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriSpScpGrpCmdtDtlVO>();
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setAcptUsrId(account.getUsr_id());
					vo[i].setAcptOfcCd(account.getOfc_cd());
					vo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(vo[i]);
				}
			}
		
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupCommodityDetail(updateDtlVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Commodity Group accept canceling<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO[] vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGroupCommodity(PriSpScpGrpCmdtDtlVO[] vo, SignOnUserAccount account) throws EventException{
		try {

			List<PriSpScpGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriSpScpGrpCmdtDtlVO>();
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(vo[i]);
				}
			}
		
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupCommodityDetail(updateDtlVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * handling Amend Request<br>
	 * 
	 * @param PriSpMnVO PriSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO PriSpMnVO, SignOnUserAccount account) throws EventException{
		try {

			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();
			
			PriSpMnVO.setCreUsrId(account.getUsr_id());
			PriSpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(PriSpMnVO);

			dbDao.addGroupCommodityAmend (insertVoList);
			dbDao.addGroupCommodityDetailAmend (insertVoList);
				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Proposal Scope Group Commodity Copying<br>
     * 
     * @param  RsltPropCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeCommodity(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_GRP_CMDT COPY
            dbDao.addCopyProposalScopeCommodity(vo);
            // PRI_SP_SCP_GRP_CMDT_DTL COPY
            dbDao.addCopyProposalScopeCommodityDtl(vo);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
    }

    /**
     * Copying Guideline Commodity Group to Proposal<br>
     * 
     * @param SpScpGlineCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdt (SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());

            // PRI_SP_SCP_GRP_CMDT COPY
            dbDao.addCopyScopeGuidelineGrpCmdt(vo);
            // PRI_SP_SCP_GRP_CMDT_DTL COPY
            dbDao.addCopyScopeGuidelineGrpCmdtDtl(vo);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
    }
    
    /**
     * Copying Guideline TPW Commodity Group to Proposal<br>
     * 
     * @param SpScpGlineCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdtTpw (SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());

            String master = vo.getCmdtTpwMst();
            String detail = vo.getCmdtTpwDtl();
            String[] mstRows = null;
            String[] mstKeys = null;
            String[] dtlArr = null;
            String[] dtlRows = null;
            String[] dtlKeys = null;
            SpScpGlineCopyVO cmdtVo = new SpScpGlineCopyVO();
            
            if (master != null) {
                mstRows = master.split(";");

                for (int i = 0, n = mstRows.length ; i < n ; i++) {
                    mstKeys = mstRows[i].split("\\|");
                    if (mstKeys.length < 5) {
                        continue;
                    }
                    cmdtVo = new SpScpGlineCopyVO();
                    ObjectCloner.build(vo, cmdtVo);
                    cmdtVo.setGrpCmdtSeq(mstKeys[3]);
                    cmdtVo.setNewGrpCmdtSeq(mstKeys[4]);
                    // PRI_SP_SCP_GRP_CMDT COPY
                    dbDao.addCopyScopeGuidelineGrpCmdtTpw(cmdtVo);    
                }
            }
            
            if (detail != null) {
                dtlArr = detail.split(",");
                SpScpGlineCopyVO cmdtDtlVo = null;
                for (int i = 0, n = dtlArr.length ; i < n ; i++) {
                    dtlRows = dtlArr[i].split(";");

                    for (int j = 0, m = dtlRows.length ; j < m ; j++) {
                        dtlKeys = dtlRows[j].split("\\|");
                        if (dtlKeys.length < 7) {
                            continue;
                        }
                        cmdtDtlVo = new SpScpGlineCopyVO();
                        ObjectCloner.build(vo, cmdtDtlVo);

                        cmdtDtlVo.setGrpCmdtSeq(dtlKeys[3]);
                        cmdtDtlVo.setGrpCmdtDtlSeq(dtlKeys[4]);
                        cmdtDtlVo.setNewGrpCmdtSeq(dtlKeys[5]);
                        cmdtDtlVo.setNewGrpCmdtDtlSeq(dtlKeys[6]);
                        // PRI_SP_SCP_GRP_CMDT_DTL COPY
                        dbDao.addCopyScopeGuidelineGrpCmdtDtlTpw(cmdtDtlVo);
                    }
                }

            }
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
    }
    
 	
	/**
	 * when canceling Request , setting all accepted data with Init state <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancel(priSpScpMnVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * deleting all data in this SCOPE<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalCmdtDtl(priSpScpMnVO);
			dbDao.removeProposalCmdt(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
		
	
	/**
	 * Commodity Group Detail retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailHistoryList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityDetailHistoryList(priSpScpGrpCmdtDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Commodity Group retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtVO   priSpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityHistoryList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityHistoryList(priSpScpGrpCmdtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	
	/**
	 * Commodity Group Detail retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailInquiryList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityDetailInquiryList(priSpScpGrpCmdtDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Commodity Group retrieving<br>
	 * 
	 * @param PriSpScpGrpCmdtVO   priSpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityInquiryList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityInquiryList(priSpScpGrpCmdtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
}