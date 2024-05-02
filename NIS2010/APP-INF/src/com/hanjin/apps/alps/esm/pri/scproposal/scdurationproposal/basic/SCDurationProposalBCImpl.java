/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCDurationProposalBCImpl.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.13 변영주
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.integration.SCDurationProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstAcceptDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstAuthorityVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstPriSpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurCntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.GrpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.RsltPriSpDurHisVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.RsltPriSpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpDurVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0020EventResponse,SCDurationProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */ 
public class SCDurationProposalBCImpl extends BasicCommandSupport implements SCDurationProposalBC {

	// Database Access Object
	private transient SCDurationProposalDBDAO dbDao = null;

	/**
	 * SCDurationProposalBCImpl 객체 생성<br>
	 * SCDurationProposalDBDAO를 생성한다.<br>
	 */
	public SCDurationProposalBCImpl() { 
		dbDao = new SCDurationProposalDBDAO();
	}

	
	/**
	 *  SC Duration 정보를 입력/수정/삭제 합니다.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpDurVO[] durVo = scPropMnVO.getPriSpDurVOs();
			PriSpScpDurVO[] scpDurVo = scPropMnVO.getPriSpScpDurVOs();
			PriSpMnVO[] mnVo = scPropMnVO.getPriSpMnVOs();
			List<PriSpDurVO> insertDurVoList = new ArrayList<PriSpDurVO>();
			List<PriSpScpDurVO> insertScpDurVoList = new ArrayList<PriSpScpDurVO>();
		
//			List<PriSpDurVO> updateDurVoList = new ArrayList<PriSpDurVO>();
			List<PriSpScpDurVO> updateDurVoList = new ArrayList<PriSpScpDurVO>();
			
			List<PriSpScpDurVO> updateScpDurVoList = new ArrayList<PriSpScpDurVO>();
		
//			List<PriSpScpDurVO> deleteScpDurVoList = new ArrayList<PriSpScpDurVO>();
			
			String propNo = dbDao.searchCreationProposalNo(mnVo[0].getPropOfcCd());
//			String propNo = scPropMnVO.getPropNo();
			for ( int i = 0; durVo != null && i < durVo.length; i++ ) {
				if ( durVo[i].getIbflag().equals("I")){
					durVo[i].setPropNo(propNo);
					durVo[i].setCreUsrId(account.getUsr_id());
					durVo[i].setUpdUsrId(account.getUsr_id());					
					insertDurVoList.add(durVo[i]);
				} else if ( durVo[i].getIbflag().equals("U")){
					durVo[i].setUpdUsrId(account.getUsr_id());
					PriSpScpDurVO vo = new PriSpScpDurVO();
					vo.setCtrtEffDt(durVo[i].getCtrtEffDt());
					vo.setCtrtExpDt(durVo[i].getCtrtExpDt());
					vo.setAmdtSeq(durVo[i].getAmdtSeq());
					vo.setPropNo(durVo[i].getPropNo());
//					vo.setN1stCmncDt(durVo[i].getN1stCmncDt());
					vo.setUpdUsrId(durVo[i].getUpdUsrId());
					updateDurVoList.add(vo);
				} 
			}
			
			for ( int i = 0; scpDurVo != null && i < scpDurVo.length; i++ ) {
				if ( scpDurVo[i].getIbflag().equals("I")){
					if(scpDurVo[i].getPropNo().equals("")){
						scpDurVo[i].setPropNo(propNo);
						scpDurVo[i].setAmdtSeq("0");
					}					
					scpDurVo[i].setCreUsrId(account.getUsr_id());
					scpDurVo[i].setUpdUsrId(account.getUsr_id());					
					insertScpDurVoList.add(scpDurVo[i]);
				} else if ( scpDurVo[i].getIbflag().equals("U")){
					scpDurVo[i].setUpdUsrId(account.getUsr_id());
					updateScpDurVoList.add(scpDurVo[i]);
//				} else if ( scpDurVo[i].getIbflag().equals("D")){
//					deleteScpDurVoList.add(scpDurVo[i]);					
				} 
			}	
//			if ( deleteScpDurVoList.size() > 0 ) {
//				dbDao.removeProposalScopeDuration (deleteScpDurVoList);
//			}
			if ( insertDurVoList.size() > 0 ) {
				dbDao.addProposalDuration (insertDurVoList);
			}
			if ( updateDurVoList.size() > 0 ) {
				dbDao.modifyProposalDuration (updateDurVoList);
			}
			if ( insertScpDurVoList.size() > 0 ) {
				dbDao.addProposalScopeDuration (insertScpDurVoList);
			}
			if ( updateScpDurVoList.size() > 0 ) {
				dbDao.modifyProposalScopeDuration (updateScpDurVoList);
			}
			
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  SC Duration 정보를 삭제 합니다.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeDurationRemove(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpScpDurVO[] scpDurVo = scPropMnVO.getPriSpScpDurVOs();		
			List<PriSpScpDurVO> deleteScpDurVoList = new ArrayList<PriSpScpDurVO>();
			
			for ( int i = 0; scpDurVo != null && i < scpDurVo.length; i++ ) {
				if ( scpDurVo[i].getIbflag().equals("D")){
					deleteScpDurVoList.add(scpDurVo[i]);					
				} 
			}	
			if ( deleteScpDurVoList.size() > 0 ) {
				dbDao.removeProposalScopeDuration (deleteScpDurVoList);
			}
			
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	
	
	/**
	 * Main,Scope Duration 을 Amend 합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();
			
			priSpMnVO.setCreUsrId(account.getUsr_id());
			priSpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priSpMnVO);
	
			dbDao.addProposalDurationAmend (insertVoList);
			dbDao.addProposalScopeDurationAmend (insertVoList);
				
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	

    /**
     *  Main,Scope Duration 데이터를 조회합니다.<br>
     * 
     * @param CstAuthorityVO cstAuthorityVO
     * @return GrpDurVO
     * @exception EventException
     */
	public GrpDurVO searchProposalDurationList(CstAuthorityVO cstAuthorityVO) throws EventException {
		try {
			List<RsltPriSpDurVO> rsltPriSpDurVO =  new ArrayList<RsltPriSpDurVO>();			
			GrpDurVO grpDurVO = new GrpDurVO();			
			
			if (cstAuthorityVO.getSvcScpCd().equals("")){
				rsltPriSpDurVO = dbDao.searchProposalDurationList(cstAuthorityVO);
			}else{
				rsltPriSpDurVO = dbDao.searchProposalScopeDurationList(cstAuthorityVO);
			}
			
			grpDurVO.setRsltPriSpDurVOS(rsltPriSpDurVO);
			
			return grpDurVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Main,Scope Duration 의 Request 데이터를 Accept 로 수정합니다.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDuration(PriSpScpDurVO priSpScpDurVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpScpDurVO> updateVoList = new ArrayList<PriSpScpDurVO>();
			
			priSpScpDurVO.setUpdUsrId(account.getUsr_id());	
			priSpScpDurVO.setAcptUsrId(account.getUsr_id());
			priSpScpDurVO.setAcptOfcCd(account.getOfc_cd());			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priSpScpDurVO.setAcptDt(currentDate);
			String svcScpCd = priSpScpDurVO.getSvcScpCd();

			updateVoList.add(priSpScpDurVO);

			if (svcScpCd.equals("")){
				dbDao.modifyProposalDuration (updateVoList);
			}else{
				dbDao.modifyProposalScopeDuration (updateVoList);
			}			
				
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Main Accept시 Scope의 Request 데이터를 Accept 로 수정합니다.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalScopeDuration(PriSpScpDurVO priSpScpDurVO, SignOnUserAccount account) throws EventException{
		try {		
			if (priSpScpDurVO != null){
				priSpScpDurVO.setUpdUsrId(account.getUsr_id());	
				priSpScpDurVO.setAcptUsrId(account.getUsr_id());
				priSpScpDurVO.setAcptOfcCd(account.getOfc_cd());			
				dbDao.modifyAutoAcceptProposalScopeDuration (priSpScpDurVO);
			}
				
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Main,Scope Duration 의 Accept된 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalDuration(PriSpScpDurVO priSpScpDurVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpScpDurVO> updateVoList = new ArrayList<PriSpScpDurVO>();
			
			priSpScpDurVO.setUpdUsrId(account.getUsr_id());	
			//cancel 
			priSpScpDurVO.setAcptUsrId("C");
			priSpScpDurVO.setAcptOfcCd("C");		
			priSpScpDurVO.setAcptDt("C");
			String svcScpCd = priSpScpDurVO.getSvcScpCd();

			updateVoList.add(priSpScpDurVO);

			if (svcScpCd.equals("")){
				dbDao.modifyProposalDuration (updateVoList);
			}else{
				dbDao.modifyProposalScopeDuration (updateVoList);
			}			
				
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
     * Duration 을 추가/수정/삭제합니다.<br>
	 * 
	 * @param CstPriSpScpDurVO[] cstPriSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */

	public void manageProposalDuration(CstPriSpScpDurVO[] cstPriSpScpDurVO, SignOnUserAccount account) throws EventException{
		try {
			String svcScpCd = cstPriSpScpDurVO[0].getSvcScpCd();
			String scpSave = cstPriSpScpDurVO[0].getScpSave();;
			List<PriSpScpDurVO> insertVoList = new ArrayList<PriSpScpDurVO>();
			List<PriSpScpDurVO> updateVoList = new ArrayList<PriSpScpDurVO>();
			List<PriSpScpDurVO> deleteVoList = new ArrayList<PriSpScpDurVO>();
	
			
			for ( int i=0; i<cstPriSpScpDurVO.length; i++ ) {
				if ( cstPriSpScpDurVO[i].getIbflag().equals("I")){
					cstPriSpScpDurVO[i].setUpdUsrId(account.getUsr_id());					
					cstPriSpScpDurVO[i].setCreUsrId(account.getUsr_id());
					PriSpScpDurVO priSpScpDurVO = new PriSpScpDurVO();					
					ObjectCloner.build(cstPriSpScpDurVO[i], priSpScpDurVO );					
					insertVoList.add(priSpScpDurVO);
				} else if ( cstPriSpScpDurVO[i].getIbflag().equals("U")){
					cstPriSpScpDurVO[i].setUpdUsrId(account.getUsr_id());
					PriSpScpDurVO priSpScpDurVO = new PriSpScpDurVO();
					ObjectCloner.build(cstPriSpScpDurVO[i], priSpScpDurVO );

					updateVoList.add(priSpScpDurVO);
				} else if ( cstPriSpScpDurVO[i].getIbflag().equals("D")){
					PriSpScpDurVO priSpScpDurVO = new PriSpScpDurVO();
					ObjectCloner.build(cstPriSpScpDurVO[i], priSpScpDurVO );
					deleteVoList.add(priSpScpDurVO);
				}
				
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalScopeDuration (insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				if (svcScpCd.equals("")){
					if (scpSave.equals("true")){
						dbDao.modifyProposalScopeDurationChange (updateVoList);
					}
					dbDao.modifyProposalDuration (updateVoList);
				}else{
					dbDao.modifyProposalScopeDuration (updateVoList);
				}	
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeProposalScopeDuration (deleteVoList);
			}

        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
    /**
     * S/C Proposal Main Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDuration(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_DUR COPY
            dbDao.addCopyProposalDuration(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * S/C Proposal Scope Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeDuration(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_DUR COPY
            dbDao.addCopyProposalScopeDuration(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
     * Main Duration 저장 시 Scope Duration 의 기간을 조회합니다. <br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @return List<CstPriSpDurVO>
	 * @exception EventException
	 */
	public List<CstPriSpDurVO> searchProposalScopeCheckList(PriSpScpDurVO priSpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalScopeCheckList(priSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}    
    
	/**
	 * S/C Proposal Main Duration 정보를 삭제합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null){
				dbDao.removeProposal(priSpMnVO);
			}
			
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	

	/**
	 * Init Cancel시 Scope Duration 의 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScope(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null){
				dbDao.removeProposalScope(priSpScpMnVO);
			}
			
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancel(priSpMnVO);
			}
			
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Request Cancel시 Scope Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelScope(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancelScope(priSpScpMnVO);
			}
			
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Filing시 filing Date가 이전일 경우 Duration의 Effective Date를 변경한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalTerms(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalTerms (priSpMnVO);
			dbDao.modifyProposalScpTerms (priSpMnVO);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
     * Main Duration Amend Cancel시 Scope Duration 의 Amend 데이터가 있는지 조회합니다. <br>
	 * @param PriSpScpDurVO PriSpScpDurVO
	 * @return List<PriSpScpDurVO>
	 * @throws DAOException
	 */
	public List<PriSpScpDurVO> searchProposalDurationAmendCheckList(PriSpScpDurVO priSpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalDurationAmendCheckList(priSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}  	
	
	/**
     * Main Duration 저장 시 Scope Duration 의 Duration보다 이전 일자인지 조회합니다. <br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @return List<CstPriSpScpDurCntVO>
	 * @exception EventException
	 */
	public List<CstPriSpScpDurCntVO> searchProposalDurationScopeCount(PriSpScpDurVO priSpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalDurationScopeCount(priSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}   	
	
	/**
	 * Scope 을 조회합니다.<br>
	 * 
	 * @param CstPriSpScpDurVO cstPriSpScpDurVO
	 * @return List<PriSpScpDurVO>
	 * @exception DAOException
	 */
	public List<PriSpScpDurVO> searchProposalScope(CstPriSpScpDurVO cstPriSpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalScope(cstPriSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}   		
	
	/**
	 * Duration Amend History 를 조회합니다.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpDurHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpDurHisVO> searchProposalDurationHistoryList(PriSpScpDurVO priSpScpDurVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {

			if (priSpScpDurVO.getSvcScpCd().equals("")){
				return  dbDao.searchProposalDurationMainHistoryList(priSpScpDurVO,priSpHistoryInquiryParamVO);
			}else{
				return dbDao.searchProposalDurationScopeHistoryList(priSpScpDurVO,priSpHistoryInquiryParamVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
    
//	/**
//	 * Filing,Amend시 filing Date가 Effective Date보다 더 늦을 경우 변경한다.<br>
//	 * 
//	 * @param PriSpMnVO priSpMnVO
//     * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageProposalScopeTerms(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
//		try {
//
//			if (priSpMnVO != null  ) {
//				priSpMnVO.setUpdUsrId(account.getUsr_id());					
//			}
//
//			dbDao.modifyProposalAmendScpTerms (priSpMnVO);
//        } catch (DAOException ex) {
//            //log.error("err " + ex.toString(), ex);
//        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
//        } catch (Exception ex) {
//            //log.error("err " + ex.toString(), ex);
//        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
//        }
//	}		
	
	
	/**
	 * COPY TO PROPOSAL Duration<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalDuration(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToProposalVO.setCreUsrId(account.getUsr_id());
			rsltCopyToProposalVO.setUpdUsrId(account.getUsr_id());
			//office
			rsltCopyToProposalVO.setQttnOfcCd(account.getOfc_cd());
			
			int chk = 0;
			
			//PRI_SP_DUR
			chk = dbDao.addCopyToProposalSpDur(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			//PRI_SP_SCP_DUR
			chk = dbDao.addCopyToProposalSpScpDur(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
		} catch(EventException ex) {
			throw ex;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Main,Scope Duration 의 Request 데이터를 모두 Accept 로 수정합니다.<br>
	 * 
	 * @param CstAcceptDurVO cstAcceptDurVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllProposalDuration(CstAcceptDurVO cstAcceptDurVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			if  (cstAcceptDurVO != null){
				cstAcceptDurVO.setUpdUsrId(account.getUsr_id());	
				cstAcceptDurVO.setAcptUsrId(account.getUsr_id());
				cstAcceptDurVO.setAcptOfcCd(account.getOfc_cd());				
				cstAcceptDurVO.setAcptDt(currentDate);
				cstAcceptDurVO.setPrcProgStsCd(cstAcceptDurVO.getStsCd());
			}

			rValue = dbDao.modifyAcceptAllProposalDuration (cstAcceptDurVO);
			rValue += dbDao.modifyAcceptAllProposalScopeDuration (cstAcceptDurVO);	
				
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
		return rValue;
	}	
	
	/**
	 * Main,Scope Duration 의 Accept된 데이터를 모두 Accept Cancel 합니다.<br>
	 * 
	 * @param CstAcceptDurVO cstAcceptDurVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllProposalDuration(CstAcceptDurVO cstAcceptDurVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {			
			if (cstAcceptDurVO != null  ) {
				cstAcceptDurVO.setUpdUsrId(account.getUsr_id());					
				cstAcceptDurVO.setAcptUsrId("");
				cstAcceptDurVO.setAcptOfcCd("");								
				cstAcceptDurVO.setAcptDt(null);	
				cstAcceptDurVO.setPrcProgStsCd(cstAcceptDurVO.getStsCd());
			}	

			rValue = dbDao.modifyAcceptAllProposalDuration (cstAcceptDurVO);	
			rValue += dbDao.modifyAcceptAllProposalScopeDuration (cstAcceptDurVO);			
				
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
		return rValue;
	}	
	
	

    /**
     * 저장시 Main과 Scope의 동시 저장 여부를 체크 하기 위하여 Scope의 Count를 조회한다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
	public List<RsltCdListVO> searchDurScopeCount(PriSpMnVO priSpMnVO) throws EventException{
		try {
			return dbDao.searchDurScopeCount(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}  	
	
    /**
     * 저장시 Main Duration을 조회하여 수정된 Scope Duration이 Main Duration의 사이에 있는지 검사한다.<br>
     *
     * @param PriSpScpDurVO priSpScpDurVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchMainDuration(PriSpScpDurVO priSpScpDurVO) throws EventException{
		try {
			return dbDao.searchMainDuration(priSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	} 	
	
    /**
     * 저장시 Scope Duration을 조회하여 수정된 Main Duration이 Scope Duration의 사이에 있는지 검사한다.<br>
     *
     * @param PriSpScpDurVO priSpScpDurVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchScopeDuration(PriSpScpDurVO priSpScpDurVO) throws EventException{
		try {
			return dbDao.searchScopeDuration(priSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}     
}