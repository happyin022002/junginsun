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
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.integration.RFADurationProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstAuthorityVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurCntVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.GrpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurHisVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpDurVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpDurVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0020EventResponse,SCDurationProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RFADurationProposalBCImpl extends BasicCommandSupport implements RFADurationProposalBC {

	// Database Access Object
	private transient RFADurationProposalDBDAO dbDao = null;

	/**
	 * SCDurationProposalBCImpl 객체 생성<br>
	 * SCDurationProposalDBDAO를 생성한다.<br>
	 */
	public RFADurationProposalBCImpl() {
		dbDao = new RFADurationProposalDBDAO();
	}

	/**
	 * RFA Duration 정보를 입력/수정/삭제 합니다.
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(RfaPropMnVO rfaPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriRpDurVO[] durVo = rfaPropMnVO.getPriRpDurVOs();
			PriRpScpDurVO[] scpDurVo = rfaPropMnVO.getPriRpScpDurVOs();
			PriRpMnVO[] mnVo = rfaPropMnVO.getPriRpMnVOs();
			List<PriRpDurVO> insertDurVoList = new ArrayList<PriRpDurVO>();
			List<PriRpScpDurVO> insertScpDurVoList = new ArrayList<PriRpScpDurVO>();
		
			List<PriRpScpDurVO> updateDurVoList = new ArrayList<PriRpScpDurVO>();
			
			List<PriRpScpDurVO> updateScpDurVoList = new ArrayList<PriRpScpDurVO>();
		
			List<PriRpScpDurVO> deleteScpDurVoList = new ArrayList<PriRpScpDurVO>();
			
			String propNo = dbDao.searchCreationProposalNo(mnVo[0].getPropOfcCd());
			for ( int i = 0; durVo != null && i < durVo.length; i++ ) {
				if ( durVo[i].getIbflag().equals("I")){
					durVo[i].setPropNo(propNo);
					durVo[i].setCreUsrId(account.getUsr_id());
					durVo[i].setUpdUsrId(account.getUsr_id());					
					insertDurVoList.add(durVo[i]);
				} else if ( durVo[i].getIbflag().equals("U")){
					durVo[i].setUpdUsrId(account.getUsr_id());
					PriRpScpDurVO vo = new PriRpScpDurVO();
					vo.setCtrtEffDt(durVo[i].getCtrtEffDt());
					vo.setCtrtExpDt(durVo[i].getCtrtExpDt());
					vo.setAmdtSeq(durVo[i].getAmdtSeq());
					vo.setPropNo(durVo[i].getPropNo());
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
				} else if ( scpDurVo[i].getIbflag().equals("D")){
					deleteScpDurVoList.add(scpDurVo[i]);					
				} 
			}	
			
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
//			if ( deleteScpDurVoList.size() > 0 ) {
//				dbDao.removeProposalScopeDuration (deleteScpDurVoList);
//			}			
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	
	/**
	 * RFA Scope Duration 정보를 삭제 합니다.
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeDurationRemove(RfaPropMnVO rfaPropMnVO, SignOnUserAccount account) throws EventException{
		try {		
			PriRpScpDurVO[] scpDurVo = rfaPropMnVO.getPriRpScpDurVOs();	
			List<PriRpScpDurVO> deleteScpDurVoList = new ArrayList<PriRpScpDurVO>();			
			for ( int i = 0; scpDurVo != null && i < scpDurVo.length; i++ ) {
				if ( scpDurVo[i].getIbflag().equals("D")){
					deleteScpDurVoList.add(scpDurVo[i]);					
				} 
			}	
			if ( deleteScpDurVoList.size() > 0 ) {
				dbDao.removeProposalScopeDuration (deleteScpDurVoList);
			}			
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priRpMnVO != null  ) {
				priRpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancel(priRpMnVO);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Request Cancel시 Scope Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelScope(PriRpScpMnVO[] priRpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
			
			for ( int i = 0; priRpScpMnVO != null && i < priRpScpMnVO.length; i++ ) {
				priRpScpMnVO[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpScpMnVO[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalRequestCancelScope(updateVoList);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Init Cancel시 Main Duration 의 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priRpMnVO != null){
				dbDao.removeProposal(priRpMnVO);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Init Cancel시 Scope Duration 의 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScope(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priRpScpMnVO != null){
				dbDao.removeProposalScope(priRpScpMnVO);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Main,Scope Duration 의 Request 데이터를 Accept 로 수정합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDuration(PriRpScpDurVO priRpScpDurVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriRpScpDurVO> updateVoList = new ArrayList<PriRpScpDurVO>();
			
			priRpScpDurVO.setUpdUsrId(account.getUsr_id());	
			priRpScpDurVO.setAcptUsrId(account.getUsr_id());
			priRpScpDurVO.setAcptOfcCd(account.getOfc_cd());			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priRpScpDurVO.setAcptDt(currentDate);
			String svcScpCd = priRpScpDurVO.getSvcScpCd();

			updateVoList.add(priRpScpDurVO);

			if (svcScpCd.equals("")){
				dbDao.modifyProposalDuration (updateVoList);
			}else{
				dbDao.modifyProposalScopeDuration (updateVoList);
			}			
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
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
			List<RsltPriRpDurVO> rsltPriRpDurVO =  new ArrayList<RsltPriRpDurVO>();			
			GrpDurVO grpDurVO = new GrpDurVO();			
			
			if (cstAuthorityVO.getSvcScpCd().equals("")){
				rsltPriRpDurVO = dbDao.searchProposalDurationList(cstAuthorityVO);
			}else{
				rsltPriRpDurVO = dbDao.searchProposalScopeDurationList(cstAuthorityVO);
			}
			
			grpDurVO.setRsltPriRpDurVOS(rsltPriRpDurVO);
			
			return grpDurVO;
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
     * Duration 을 추가/수정/삭제합니다.<br>
     * @param CstPriRpScpDurVO[] cstPriRpScpDurVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalDuration(CstPriRpScpDurVO[] cstPriRpScpDurVO, SignOnUserAccount account) throws EventException{
		try {
			String svcScpCd = cstPriRpScpDurVO[0].getSvcScpCd();
			String scpSave = cstPriRpScpDurVO[0].getScpSave();;
			List<PriRpScpDurVO> insertVoList = new ArrayList<PriRpScpDurVO>();
			List<PriRpScpDurVO> updateVoList = new ArrayList<PriRpScpDurVO>();
			List<PriRpScpDurVO> deleteVoList = new ArrayList<PriRpScpDurVO>();
	
			
			for ( int i=0; i<cstPriRpScpDurVO.length; i++ ) {
				if ( cstPriRpScpDurVO[i].getIbflag().equals("I")){
					cstPriRpScpDurVO[i].setUpdUsrId(account.getUsr_id());					
					cstPriRpScpDurVO[i].setCreUsrId(account.getUsr_id());
					PriRpScpDurVO priRpScpDurVO = new PriRpScpDurVO();					
					ObjectCloner.build(cstPriRpScpDurVO[i], priRpScpDurVO );					
					insertVoList.add(priRpScpDurVO);
				} else if ( cstPriRpScpDurVO[i].getIbflag().equals("U")){
					cstPriRpScpDurVO[i].setUpdUsrId(account.getUsr_id());
					PriRpScpDurVO priRpScpDurVO = new PriRpScpDurVO();
					ObjectCloner.build(cstPriRpScpDurVO[i], priRpScpDurVO );
					updateVoList.add(priRpScpDurVO);
				} else if ( cstPriRpScpDurVO[i].getIbflag().equals("D")){
					PriRpScpDurVO priRpScpDurVO = new PriRpScpDurVO();
					ObjectCloner.build(cstPriRpScpDurVO[i], priRpScpDurVO );
					deleteVoList.add(priRpScpDurVO);
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
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Main,Scope Duration 의 Accept된 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalDuration(PriRpScpDurVO priRpScpDurVO, SignOnUserAccount account) throws EventException{
		try {		
			List<PriRpScpDurVO> updateVoList = new ArrayList<PriRpScpDurVO>();			
			priRpScpDurVO.setUpdUsrId(account.getUsr_id());	
			//cancel 
			priRpScpDurVO.setAcptUsrId("C");
			priRpScpDurVO.setAcptOfcCd("C");		
			priRpScpDurVO.setAcptDt("C");
			String svcScpCd = priRpScpDurVO.getSvcScpCd();
			updateVoList.add(priRpScpDurVO);
			if (svcScpCd.equals("")){
				dbDao.modifyProposalDuration (updateVoList);
			}else{
				dbDao.modifyProposalScopeDuration (updateVoList);
			}			
				
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
     * Main Duration 저장 시 Scope Duration 의 기간을 조회합니다. <br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<CstPriRpDurVO>
	 * @exception EventException
	 */
	public List<CstPriRpDurVO> searchProposalScopeCheckList(PriRpScpDurVO priRpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalScopeCheckList(priRpScpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   	
	
	/**
     * Main Duration Amend 시 Scope Duration 의 Amend 데이터가 있는지 조회합니다. <br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<PriRpScpDurVO>
	 * @exception EventException
	 */
	public List<PriRpScpDurVO> searchProposalDurationAmendCheckList(PriRpScpDurVO priRpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalDurationAmendCheckList(priRpScpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	/**
     * Main Duration 저장 시 Scope Duration 의 Duration보다 작은 값인지 조회합니다. <br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<CstPriRpScpDurCntVO>
	 * @exception EventException
	 */
	public List<CstPriRpScpDurCntVO> searchProposalDurationScopeCount(PriRpScpDurVO priRpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalDurationScopeCount(priRpScpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   	
	
	/**
	 * Main,Scope Duration 을 Amend 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();
			
			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priRpMnVO);
	
			dbDao.addProposalDurationAmend (insertVoList);
			dbDao.addProposalScopeDurationAmend (insertVoList);
			if (!priRpMnVO.getExpDt().equals("")){
				log.debug("amendProposal==exp_dt==dur"+priRpMnVO.getExpDt());
				dbDao.modifyProposalScopeDurationAmd(insertVoList);	
				log.debug("exp_dt==============duration="+priRpMnVO.getExpDt());
			}
			
				//modifyProposalScopeDurationAmd
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Main Duration 변경시 Scope의 Expire Date 가 Main Duration의 Expire Date와 <br>
	 * 같거나 이전 일자인 Scope 을 조회합니다.<br>
	 * 
	 * @param CstPriRpScpDurVO cstPriRpScpDurVO
	 * @return List<PriRpScpDurVO>
	 * @exception DAOException
	 */
	public List<PriRpScpDurVO> searchProposalScope(CstPriRpScpDurVO cstPriRpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalScope(cstPriRpScpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   
	
	/**
	 * Duration Amend History 를 조회합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltPriRpDurHisVO>
	 * @exception EventException
	 */
	public List<RsltPriRpDurHisVO> searchProposalDurationHistoryList(PriRpScpDurVO priRpScpDurVO) throws EventException {
		try {

			if (priRpScpDurVO.getSvcScpCd().equals("")){
				return  dbDao.searchProposalDurationMainHistoryList(priRpScpDurVO);
			}else{
				return dbDao.searchProposalDurationScopeHistoryList(priRpScpDurVO);
			}
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * RFA Proposal Main Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDuration(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_DUR COPY
            dbDao.addCopyProposalDuration(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }


    /**
     * Master RFA Proposal Main Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDurationMst(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_DUR COPY
            dbDao.addCopyProposalDurationMst(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * RFA Proposal Scope Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeDuration(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_SCP_DUR COPY
            dbDao.addCopyProposalScopeDuration(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Master RFA 에서 Proposal Scope Duration 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void copyProposalScopeDurationMst(RsltRfaPropCopyVO vo, PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_SCP_DUR COPY
            dbDao.addCopyProposalScopeDurationMst(vo, priRpMnVO.getEffDt(), priRpMnVO.getExpDt());
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
    
	/**
	 * Main Duration Accept시 메인과 Expire Date가 같은 Scope을 조회합니다.<br>
	 * 
	 * @param PriRpDurVO priRpDurVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalDurationAcceptCount(PriRpDurVO priRpDurVO) throws EventException {
		try {
			log.debug("searchProposalDurationAcceptCount=======================bc ");
			return dbDao.searchProposalDurationAcceptCount(priRpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	 
	
	/**
	 * Main Accept시 Scope의 Request 데이터를 Accept 로 수정합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAutoProposalScopeDuration(PriRpScpDurVO priRpScpDurVO,SignOnUserAccount account) throws EventException{
		try {
		
			priRpScpDurVO.setAcptUsrId(account.getUsr_id());
			priRpScpDurVO.setUpdUsrId(account.getUsr_id());
			priRpScpDurVO.setAcptOfcCd(account.getOfc_cd());

            dbDao.modifyAcceptAutoProposalScopeDuration(priRpScpDurVO);	
				
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	
	/**
     * RFA Proposal Scope Duration 정보를 Copy 합니다.[PRS]<br>
     * 
     * @param RsltCopyToProposalVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyToProposalScopeDuration(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            
            int chk = 0;
        
            // PRI_RP_DUR COPY
            chk = dbDao.addCopyRfaQuotationPriRpDur(vo);
            if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
            // PRI_RP_SCP_DUR COPY
            chk = dbDao.addCopyRfaQuotationPriRpScpDur(vo);
            if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
        } catch(EventException ex) {
			throw ex;    
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * Main Duration Accept시 메인과 Expire Date가 같은 Scope을 조회합니다.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalDurationAcceptList(PriRpScpDurVO priRpScpDurVO) throws EventException {
		try {
			log.debug("searchProposalDurationAcceptList=======================bc ");
			return dbDao.searchProposalDurationAcceptList(priRpScpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	    
}