/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityProposalBCImpl.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.25 최성민
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.integration.SCGroupCommodityProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.vo.GrpCmdtPropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0003_03EventResponse,SCGroupCommodityProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */ 
public class SCGroupCommodityProposalBCImpl extends BasicCommandSupport implements SCGroupCommodityProposalBC {

	// Database Access Object
	private transient SCGroupCommodityProposalDBDAO dbDao = null;

	/**
	 * SCGroupCommodityProposalBCImpl 객체 생성<br>
	 * SCGroupCommodityProposalDBDAO를 생성한다.<br>
	 */
	public SCGroupCommodityProposalBCImpl() {
		dbDao = new SCGroupCommodityProposalDBDAO();
	}
		
	/**
	 * Commodity Group Detail 정보를 조회한다.<br>
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
	 * Commodity Group 정보를 조회한다.<br>
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
	 * GRI COMMODITY GROUP & GRP COMMODITY GROUP에서 사용중인 데이터를 조회한다. <br>
	 * 삭제하기전에 위 2개의 테이블에 데이터가 존재하면 삭제불가<br>
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
	 * COMMODITY GROUP DTL 에서 사용중인 데이터를 조회한다. <br>
	 * 테이블에 데이터가 존재하면 삭제불가<br>
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
	 * Guideline Commodity Group Detail 정보를 복사한다.<br>
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
	 * Commodity Group 정보를저장한다.<br>
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
	 * Commodity Group 정보를 승인한다.<br>
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
	 * Commodity Group 정보를 승인취소한다.<br>
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
	 * Commodity Group 정보를 승인한다.<br>
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
	 * Commodity Group 정보를 승인취소한다.<br>
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
	 * Amend Request를 처리합니다.<br>
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
// pri_sp_scp_grp_cmdt 생성
// pri_sp_scp_grp_cmdt_dtl 생성
			dbDao.addGroupCommodityAmend (insertVoList);
			dbDao.addGroupCommodityDetailAmend (insertVoList);
				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Proposal Scope Group Commodity 를 Copy 합니다.<br>
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
     * Guideline Commodity Group 을 Proposal 로 Copy 합니다.<br>
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
     * Guideline TPW Commodity Group 을 Proposal 로 Copy 합니다.<br>
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
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalRequestCancel(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
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
	 * Commodity Group Detail 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO   priSpScpGrpCmdtDtlVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailHistoryList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityDetailHistoryList(priSpScpGrpCmdtDtlVO,priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Commodity Group 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO   priSpScpGrpCmdtVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityHistoryList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityHistoryList(priSpScpGrpCmdtVO,priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	
	/**
	 * Commodity Group Detail 정보를 조회한다.<br>
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
	 * Commodity Group 정보를 조회한다.<br>
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
	
	/**
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상테이블 : PRI_SP_SCP_CMDT,PRI_SP_SCP_CMDT_DTL<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalCmdt(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToProposalVO.setCreUsrId(account.getUsr_id());
			rsltCopyToProposalVO.setUpdUsrId(account.getUsr_id());
			//office
			rsltCopyToProposalVO.setQttnOfcCd(account.getOfc_cd());
			
			//PRI_SP_SCP_CMDT
			dbDao.addCopyToProposalSpScpGrpCmdt(rsltCopyToProposalVO);
			//PRI_SP_SCP_CMDT_DTL
			dbDao.addCopyToProposalSpScpGrpCmdtDtl(rsltCopyToProposalVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
		
}